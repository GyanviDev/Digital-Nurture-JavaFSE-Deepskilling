package com.digitalnurture.testing.mockito;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

    @Mock
    private ExternalBankApi mockBankApi;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Test
    public void testCurrencyConversion_VerifiesAuditLogInteraction() {
        // --- ARRANGE ---
        when(mockBankApi.getConversionRate("USD", "INR")).thenReturn(83.50);

        // --- ACT ---
        double convertedAmount = exchangeRateService.convertCurrency(100.0, "USD", "INR");

        // --- ASSERT (State) ---
        assertEquals(8350.0, convertedAmount, "Calculated amount is incorrect");

        // --- ASSERT (Behavior / Interaction Verification) ---
        // 1. Verify the exact arguments passed to the side-effect method
        verify(mockBankApi, times(1)).logConversion(eq("USD"), eq("INR"), eq(8350.0));
        
        // 2. Verify the stubbed method was actually called during the transaction
        verify(mockBankApi, times(1)).getConversionRate(eq("USD"), eq("INR"));
        
        // 3. Enterprise Guardrail: Ensure the service didn't trigger any other hidden API calls
        verifyNoMoreInteractions(mockBankApi);
    }
}