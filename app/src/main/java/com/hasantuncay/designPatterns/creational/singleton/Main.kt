package com.hasantuncay.designPatterns.creational.singleton


    fun main(args: Array<String>) {
        val dbConnection = DatabaseConnection.getInstance()
        dbConnection.connect()

        //kotlin
        DatabaseManager.connect()
        // Veritabanı işlemleri yapılır s
        DatabaseManager.disconnect()
    }
