package com.cognizant.spring_learn.service;

import com.cognizant.spring_learn.Country;
import com.cognizant.spring_learn.service.exception.CountryNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CountryService {

    private final ApplicationContext context;

    public CountryService() {
        this.context = new ClassPathXmlApplicationContext("country.xml");
    }

    public Country getCountry(String code) throws CountryNotFoundException {
        // Load country list from country.xml
        ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
        
        // Iterate through the country list and perform a case-insensitive match
        for (Country country : countryList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        
        // Throw exception if the country code does not exist in the list[cite: 2]
        throw new CountryNotFoundException("Country not found");
    }
}