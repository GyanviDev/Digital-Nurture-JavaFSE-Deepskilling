package com.digitalnurture.testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionsTest {

    @Test
    public void testBusinessLogicAssertions() {
        Calculator calc = new Calculator();
        
        // 1. Assert Equals - Validating mathematical business logic
        assertEquals(5, calc.add(2, 3), "Addition logic failed");
        
        // 2. Assert True - Validating boolean logic for positive numbers
        assertTrue(calc.isPositive(10), "Number 10 should be evaluated as positive");
        
        // 3. Assert False - Validating boolean logic for negative numbers
        assertFalse(calc.isPositive(-5), "Number -5 should not be evaluated as positive");
        
        // 4. Assert Not Null - Validating that critical objects are instantiated
        assertNotNull(calc.getVersion(), "System version string must not be null");
        
        // 5. Assert Null - Validating correct handling of missing data
        assertNull(calc.getNullConfiguration(), "Configuration should explicitly return null");
    }
}