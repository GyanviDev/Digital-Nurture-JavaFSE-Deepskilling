package com.digitalnurture.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    // The Test Fixture
    private ShoppingCart cart;

    // SETUP: Runs exactly once BEFORE every @Test method
    @BeforeEach
    public void setUp() {
        System.out.println("Executing Setup: Initializing a fresh ShoppingCart.");
        cart = new ShoppingCart(); 
    }

    // TEARDOWN: Runs exactly once AFTER every @Test method
    @AfterEach
    public void tearDown() {
        System.out.println("Executing Teardown: Cleaning up resources.");
        cart.emptyCart();
        cart = null; 
    }

    @Test
    public void testAddItemCalculatesTotalCorrectly() {
        // --- ARRANGE ---
        // Set up the preconditions and inputs
        String product1 = "Mechanical Keyboard";
        double price1 = 150.00;
        String product2 = "Wireless Mouse";
        double price2 = 50.00;

        // --- ACT ---
        // Execute the behavior being tested
        cart.addItem(product1, price1);
        cart.addItem(product2, price2);

        // --- ASSERT ---
        // Verify the expected outcomes
        assertEquals(2, cart.getItemCount(), "Cart should contain exactly 2 items");
        assertEquals(200.00, cart.getTotalPrice(), "Total price should equal the sum of added items");
    }
}