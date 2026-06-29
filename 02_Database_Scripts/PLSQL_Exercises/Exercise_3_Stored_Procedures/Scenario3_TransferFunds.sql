/* Scenario 3: Transfer funds between accounts with sufficient balance checking and row-level locking.
*/
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account IN Accounts.AccountID%TYPE,
    p_to_account IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER
) AS
    v_from_balance Accounts.Balance%TYPE;
BEGIN
    -- Validation guardrail
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20002, 'Transfer amount must be greater than zero.');
    END IF;

    -- Step 1: Read the balance AND apply a row-level lock (FOR UPDATE)
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account
    FOR UPDATE;

    -- Step 2: Check for sufficient funds
    IF v_from_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20003, 'Insufficient funds for transfer in Account: ' || p_from_account);
    END IF;

    -- Step 3: Execute the transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account;

    -- Step 4: Lock in the transaction
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_from_account || ' to Account ' || p_to_account);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both of the specified accounts do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: ' || SQLERRM);
END;
/