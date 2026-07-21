package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;

// Change the annotation for this class from @Component to @Service
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    // Define @Transactional annotation for this method
    @Transactional
    public ArrayList<Employee> getAllEmployees() {
        // Create method getAllEmployees() that invokes employeeDao.getAllEmployees() and return the employee list
        return employeeDao.getAllEmployees();
    }

    @Transactional
    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        employeeDao.updateEmployee(employee);
    }

    @Transactional
    public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
        employeeDao.deleteEmployee(id);
    }
}