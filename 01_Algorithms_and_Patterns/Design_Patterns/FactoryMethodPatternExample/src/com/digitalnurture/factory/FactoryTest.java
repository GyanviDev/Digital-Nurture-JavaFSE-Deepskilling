package com.digitalnurture.factory;

public class FactoryTest {
    public static void main(String[] args) {
        System.out.println("--- Digital Nurture Document Processing System ---");
        
        try {
            // Client code relies entirely on the interface, not the concrete classes
            Document doc1 = DocumentFactory.createDocument("pdf");
            doc1.open();
            doc1.save();
            
            System.out.println("--------------------------------------------------");
            
            Document doc2 = DocumentFactory.createDocument("word");
            doc2.open();
            doc2.save();
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error generating document: " + e.getMessage());
        }
    }
}