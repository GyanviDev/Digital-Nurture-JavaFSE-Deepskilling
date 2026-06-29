package com.digitalnurture.logging;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LoggingApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoggingApplication.class, args);
    }

    // This runs automatically when the Spring Boot application starts up
    @Bean
    public CommandLineRunner runDemonstration(OrderProcessingService orderService) {
        return args -> {
            System.out.println("\n--- STARTING LOGGING DEMONSTRATION ---\n");
            
            orderService.processOrder("ORD-1001", 250.00); // Should trigger INFO
            orderService.processOrder("ORD-1002", 0.00);   // Should trigger INFO and WARN
            orderService.processOrder("ERR-9999", 500.00); // Should trigger INFO and ERROR
            
            System.out.println("\n--- END OF DEMONSTRATION ---\n");
        };
    }
}