package com.cognizant.ems.repository;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeNameProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    /**
     * Exercise 8: Interface-based Projection.
     * Fetches an optimized list containing only the fields defined in EmployeeNameProjection 
     * (name and email), preventing performance overhead from pulling unnecessary columns.
     */
    List<EmployeeNameProjection> findAllProjectedBy();
}