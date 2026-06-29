/* Scenario 2: Update the salary of employees in a given department by adding a bonus percentage.
*/
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN Employees.DepartmentID%TYPE,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- Validation guardrail
    IF p_bonus_percentage < 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Bonus percentage cannot be negative.');
    END IF;

    -- Apply the bonus
    UPDATE Employees
    SET Salary = Salary + (Salary * (p_bonus_percentage / 100))
    WHERE DepartmentID = p_department_id;
    
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Bonus of ' || p_bonus_percentage || '% applied to Department ' || p_department_id);

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END;
/