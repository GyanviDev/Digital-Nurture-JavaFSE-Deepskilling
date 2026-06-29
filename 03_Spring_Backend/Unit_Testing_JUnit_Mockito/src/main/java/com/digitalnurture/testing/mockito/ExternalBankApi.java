package com.digitalnurture.testing.mockito;

// This represents the external API we cannot hit during unit testing
public interface ExternalBankApi {
    double getConversionRate(String fromCurrency, String toCurrency);
}