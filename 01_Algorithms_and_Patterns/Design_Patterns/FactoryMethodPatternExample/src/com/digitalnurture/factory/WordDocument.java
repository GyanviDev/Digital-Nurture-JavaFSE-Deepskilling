package com.digitalnurture.factory;

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening Word Document with edit permissions.");
    }

    @Override
    public void save() {
        System.out.println("Saving Word Document to cloud storage.");
    }
}