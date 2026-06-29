package com.digitalnurture.factory;

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF Document in secure read-only mode.");
    }

    @Override
    public void save() {
        System.out.println("Saving PDF Document with AES-256 encryption.");
    }
}