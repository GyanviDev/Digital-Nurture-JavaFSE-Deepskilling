package com.digitalnurture.factory;

public class DocumentFactory {
    
    // The Factory Method
    public static Document createDocument(String docType) {
        if (docType == null || docType.trim().isEmpty()) {
            throw new IllegalArgumentException("Document type cannot be null or empty.");
        }
        
        switch (docType.toLowerCase()) {
            case "pdf":
                return new PdfDocument();
            case "word":
                return new WordDocument();
            default:
                throw new IllegalArgumentException("Unknown document type: " + docType);
        }
    }
}