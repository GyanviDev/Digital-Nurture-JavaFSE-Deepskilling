package com.cognizant.ems.repository;

import com.cognizant.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // JpaRepository already includes findAll(Pageable pageable) for Exercise 6
}