/* Scenario 1: Process monthly interest for all savings accounts.
*/
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- Apply a 1% interest rate to all SAVINGS accounts
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01)
    WHERE AccountType = 'SAVINGS';
    
    -- Lock in the transaction
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully for all savings accounts.');

EXCEPTION
    WHEN OTHERS THEN
        -- Revert changes if anything fails
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Critical Error processing interest: ' || SQLERRM);
END;
/