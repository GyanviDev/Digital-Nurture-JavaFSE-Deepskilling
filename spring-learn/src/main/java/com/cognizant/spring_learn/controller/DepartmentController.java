package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.model.Department;
import com.cognizant.spring_learn.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

@RestController
public class DepartmentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    // getAllDepartments() with URL "/departments", this method will return array of departments[cite: 2]
    @GetMapping("/departments")
    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("START getAllDepartments");
        ArrayList<Department> departments = departmentService.getAllDepartments();
        LOGGER.info("END getAllDepartments");
        return departments;
    }
}