package com.hasantuncay.designPatterns.creational.singleton

object DatabaseManager {
    init {
        // İlk başlatma işlemleri burada yapılabilir
        println("DatabaseManager is created")
    }

    fun connect() {
        // Veritabanına bağlanma işlemleri burada simüle edilebilir
        println("Database Connected")
    }

    fun disconnect() {
        // Veritabanı bağlantısının kesilmesi işlemleri
        println("Database Disconnected")
    }
}
