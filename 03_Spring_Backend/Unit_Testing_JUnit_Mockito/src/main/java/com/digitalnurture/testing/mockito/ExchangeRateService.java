package com.digitalnurture.testing.mockito;

public class ExchangeRateService {
    
    private final ExternalBankApi bankApi;

    public ExchangeRateService(ExternalBankApi bankApi) {
        this.bankApi = bankApi;
    }

    public double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        if (amount < 0) {
            throw new IllegalArgumentException("Transfer amount cannot be negative");
        }
        
        double rate = bankApi.getConversionRate(fromCurrency, toCurrency);
        double finalAmount = amount * rate;
        
        // NEW: Trigger the external audit log
        bankApi.logConversion(fromCurrency, toCurrency, finalAmount);
        
        return finalAmount;
    }
}