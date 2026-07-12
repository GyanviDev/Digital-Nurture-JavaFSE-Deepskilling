package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // Generates: SELECT * FROM country WHERE co_name LIKE '%name%' ORDER BY co_name ASC
    List<Country> findByNameContainingOrderByNameAsc(String name);
}