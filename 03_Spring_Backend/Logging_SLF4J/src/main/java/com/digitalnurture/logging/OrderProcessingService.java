package com.digitalnurture.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OrderProcessingService {

    // Initialize the SLF4J Logger for this specific class
    private static final Logger logger = LoggerFactory.getLogger(OrderProcessingService.class);

    public void processOrder(String orderId, double amount) {
        logger.info("Initiating processing for Order ID: {}", orderId);

        if (amount <= 0) {
            // WARN level: The application can continue, but a business rule was violated
            logger.warn("Order {} contains a zero or negative amount (${}). Manual review flagged.", orderId, amount);
        }

        try {
            // Simulating a database failure
            if (orderId.startsWith("ERR")) {
                throw new RuntimeException("Database connection timeout during order commit.");
            }
            logger.info("Order ID: {} processed successfully.", orderId);
            
        } catch (Exception e) {
            // ERROR level: A technical failure occurred that breaks the flow
            logger.error("Critical failure while processing Order ID: {}", orderId, e);
        }
    }
}