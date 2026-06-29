/*
Scenario 2: Promote customer to VIP status based on balance over $10,000.
*/
SET SERVEROUTPUT ON;

BEGIN
    -- Implicit cursor FOR loop
    FOR high_balance_rec IN (
        SELECT CustomerID, Balance 
        FROM Customers 
        WHERE Balance > 10000
    ) LOOP
        
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = high_balance_rec.CustomerID;
        
    END LOOP;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('VIP Status updated for eligible customers.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating VIP status: ' || SQLERRM);
END;
/