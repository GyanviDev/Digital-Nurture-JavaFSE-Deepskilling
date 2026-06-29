package com.digitalnurture.testing.mockito;

public interface ExternalBankApi {
    double getConversionRate(String fromCurrency, String toCurrency);
    
    // NEW: A void method representing a side-effect (like an audit log)
    void logConversion(String fromCurrency, String toCurrency, double convertedAmount);
}