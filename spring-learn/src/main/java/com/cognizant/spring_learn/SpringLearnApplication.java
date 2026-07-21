package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@SpringBootApplication
@ImportResource({"classpath:date-format.xml", "classpath:country.xml"})
public class SpringLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringLearnApplication.class, args);
        
        displayDate(context);
        displayCountry(context);
        displayCountries(context);
    }

    public static void displayDate(ApplicationContext context) {
        LOGGER.info("START displayDate");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date date = format.parse("31/12/2018");
            LOGGER.debug("Parsed Date: {}", date);
        } catch (ParseException e) {
            LOGGER.error("Date parsing failed", e);
        }
        LOGGER.info("END displayDate");
    }

    public static void displayCountry(ApplicationContext context) {
        LOGGER.info("START displayCountry");
        Country country = context.getBean("country", Country.class);
        Country anotherCountry = context.getBean("country", Country.class);
        
        LOGGER.debug("Country 1: {}", country);
        LOGGER.debug("Country 2: {}", anotherCountry);
        LOGGER.info("END displayCountry");
    }

    public static void displayCountries(ApplicationContext context) {
        LOGGER.info("START displayCountries");
        @SuppressWarnings("unchecked")
        ArrayList<Country> countryList = context.getBean("countryList", ArrayList.class);
        LOGGER.debug("Country List: {}", countryList);
        LOGGER.info("END displayCountries");
    }
}