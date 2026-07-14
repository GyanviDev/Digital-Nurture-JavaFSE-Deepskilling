package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        
        LOGGER.info("--- Starting Database Operations Test ---");
        
        try {
            testFindCountryByCode();
            testAddCountry();
            testUpdateCountry();
            testDeleteCountry();
            testSearchCountries();
            testSearchCountriesByStartingLetter();
        } catch (Exception e) {
            LOGGER.error("Application test failed: ", e);
        }
    }

    private static void testFindCountryByCode() throws CountryNotFoundException {
        LOGGER.info("Start testFindCountryByCode");
        Country country = countryService.findCountryByCode("IN");
        LOGGER.debug("Found Country: {}", country);
        LOGGER.info("End testFindCountryByCode\n");
    }

    private static void testAddCountry() throws CountryNotFoundException {
        LOGGER.info("Start testAddCountry");
        Country newCountry = new Country();
        newCountry.setCode("MM");
        newCountry.setName("Micro-Nation");
        
        countryService.addCountry(newCountry);
        Country verifyCountry = countryService.findCountryByCode("MM");
        LOGGER.debug("Added Country: {}", verifyCountry);
        LOGGER.info("End testAddCountry\n");
    }

    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start testUpdateCountry");
        countryService.updateCountry("MM", "Modified Micro-Nation");
        
        Country verifyCountry = countryService.findCountryByCode("MM");
        LOGGER.debug("Updated Country: {}", verifyCountry);
        LOGGER.info("End testUpdateCountry\n");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("MM");
        
        try {
            countryService.findCountryByCode("MM");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Success: Country 'MM' was successfully deleted and could not be found.");
        }
        LOGGER.info("End testDeleteCountry\n");
    }

    private static void testSearchCountries() {
        LOGGER.info("Start testSearchCountries");
        List<Country> countries = countryService.searchCountriesByName("ou");
        LOGGER.debug("Countries containing 'ou': {}", countries);
        LOGGER.info("End testSearchCountries\n");
    }

    private static void testSearchCountriesByStartingLetter() {
        LOGGER.info("Start testSearchCountriesByStartingLetter");
        List<Country> countries = countryService.searchCountriesByStartingLetter("U");
        LOGGER.debug("Countries starting with 'U': {}", countries);
        LOGGER.info("End testSearchCountriesByStartingLetter\n");
    }
}