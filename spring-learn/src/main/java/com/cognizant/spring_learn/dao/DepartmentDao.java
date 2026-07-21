package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class DepartmentDao {
    // Create a static variable DEPARTMENT_LIST, this should be populated from spring xml configuration[cite: 2]
    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = context.getBean("departmentList", ArrayList.class);
    }

    // getAllDepartments()[cite: 2]
    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}