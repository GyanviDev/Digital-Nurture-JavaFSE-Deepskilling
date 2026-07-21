package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class EmployeeDao {
    // Create static variable with name EMPLOYEE_LIST of type ArrayList<Employee>
    private static ArrayList<Employee> EMPLOYEE_LIST;

    // Include constructor that reads employee list from xml config and set the EMPLOYEE_LIST
    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = context.getBean("employeeList", ArrayList.class);
    }

    // Create method getAllEmployees() that returns the EMPLOYEE_LIST
    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee updatedEmployee) throws EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(updatedEmployee.getId())) {
                EMPLOYEE_LIST.set(i, updatedEmployee);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }

    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(id)) {
                EMPLOYEE_LIST.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException("Employee not found");
    }
}