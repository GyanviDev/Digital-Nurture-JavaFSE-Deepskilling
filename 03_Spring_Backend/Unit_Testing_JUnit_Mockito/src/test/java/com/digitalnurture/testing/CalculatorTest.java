package com.digitalnurture.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        int result = calculator.add(10, 5);
        
        // Assert that 10 + 5 equals 15
        assertEquals(15, result, "The add method should return the sum of two integers");
    }
}