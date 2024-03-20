package com.hasantuncay.designPatterns.creational.singleton;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        dbConnection.connect();
    }
}

