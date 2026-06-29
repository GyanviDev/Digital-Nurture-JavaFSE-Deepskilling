/*
Scenario 3: Send reminders to customers whose loans are due within the next 30 days.
*/
SET SERVEROUTPUT ON;

BEGIN
    DBMS_OUTPUT.PUT_LINE('--- LOAN REMINDER REPORT ---');
    
    -- Iterate through loans due between today (SYSDATE) and 30 days from today
    FOR due_loan_rec IN (
        SELECT c.CustomerName, l.LoanID, l.DueDate 
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        
        -- Print the reminder message
        DBMS_OUTPUT.PUT_LINE('REMINDER: Customer ' || due_loan_rec.CustomerName || 
                             ' - Loan ID ' || due_loan_rec.LoanID || 
                             ' is due on ' || TO_CHAR(due_loan_rec.DueDate, 'YYYY-MM-DD'));
                             
    END LOOP;
    
    DBMS_OUTPUT.PUT_LINE('--- END OF REPORT ---');
    
EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error generating report: ' || SQLERRM);
END;
/