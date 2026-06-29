/* Scenario 1: Apply a discount to loan interest rates for customers above 60 years old.
*/
SET SERVEROUTPUT ON;

BEGIN
    -- Implicit cursor FOR loop to iterate through customers above 60
    FOR customer_rec IN (
        SELECT CustomerID, Age 
        FROM Customers 
        WHERE Age > 60
    ) LOOP
        -- Update the loan interest rate for the matching customer
        UPDATE Loans
        SET InterestRate = InterestRate - 1.00
        WHERE CustomerID = customer_rec.CustomerID;
        
        -- Optional log output for tracking
        DBMS_OUTPUT.PUT_LINE('Discount applied for Customer ID: ' || customer_rec.CustomerID);
    END LOOP;
    
    COMMIT; -- Save changes
    DBMS_OUTPUT.PUT_LINE('Scenario 1 Execution Completed Successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error encountered. Transaction rolled back. Code: ' || SQLCODE);
END;
/