package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Document 3: Hands-on 2 - Get all permanent employees using HQL with JOIN FETCH
    @Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Document 3: Hands-on 4 - Get average salary of a department
    @Query(value="SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Document 3: Hands-on 5 - Native Query
    @Query(value="SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}