package com.hasantuncay.designPatterns.creational.singleton;

public class DatabaseConnection {
    // Tek nesne örneğini tutacak statik değişken
    private static DatabaseConnection instance;

    // Constructor'ı private yaparak dışarıdan nesne üretimini engelleyin
    private DatabaseConnection() {
        // Burada veritabanı bağlantısı gibi işlemler yapılabilir
    }

    // Nesne örneğine erişim sağlayan statik metod
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        // Veritabanına bağlanma işlemleri
        System.out.println("Database connected.");
    }
}
