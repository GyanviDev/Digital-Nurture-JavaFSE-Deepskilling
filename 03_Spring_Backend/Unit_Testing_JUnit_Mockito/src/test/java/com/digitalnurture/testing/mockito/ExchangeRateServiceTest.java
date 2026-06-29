package com.digitalnurture.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

// 1. Activate Mockito for this test class
@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

    // 2. Create the mock of the external dependency
    @Mock
    private ExternalBankApi mockBankApi;

    // 3. Automatically inject the mock into the service we are testing
    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Test
    public void testCurrencyConversion_Success() {
        // --- ARRANGE ---
        // Stub the method: "When asked for USD to INR, return 83.50"
        when(mockBankApi.getConversionRate("USD", "INR")).thenReturn(83.50);

        // --- ACT ---
        // We pass 100 dollars. The service should multiply 100 * 83.50
        double convertedAmount = exchangeRateService.convertCurrency(100.0, "USD", "INR");

        // --- ASSERT ---
        assertEquals(8350.0, convertedAmount, "The service did not correctly apply the mocked exchange rate");
    }
}