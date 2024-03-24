package com.hasantuncay.kotlin.break_continue

class OrderProcessor {
    data class Order(val id: Int, val amount: Double, val category: String)

    private val orders = listOf(
        Order(1, 100.0, "Electronics"),
        Order(2, 20.0, "Books"),
        Order(3, 200.0, "Electronics"),
        Order(4, 50.0, "Clothes"),
        Order(5, 10.0, "Books"),
        Order(6, 400.0, "Electronics"),
        Order(7, 30.0, "Clothes"),
        Order(8, 70.0, "Books")
    )

    fun processOrders() {
        val processedOrders = mutableListOf<Order>()

        // Siparişleri işleyen döngü
        for (order in orders) {
            // Belirli bir kategoriye ait siparişleri atlamak
            if (order.category == "Books") continue

            // Sipariş miktarı belirli bir değerden büyükse işlemi durdur
            if (order.amount > 300) break

            processedOrders.add(order)
        }

        println("İşlenen Siparişler: $processedOrders")
    }

    // Etiketli döngü kullanımı
    fun processOrdersWithLabels() {
        val highValueOrders = mutableListOf<Order>()

        outerLoop@ for (order in orders) {
            // Sipariş kategorisine göre iç döngü
            for (category in listOf("Electronics", "Clothes")) {
                if (order.category == category && order.amount > 100) {
                    highValueOrders.add(order)
                    continue@outerLoop // Dış döngünün bir sonraki iterasyonuna geç
                }
            }
        }

        println("Yüksek Değerli Siparişler: $highValueOrders")
    }
}

fun main() {
    val orderProcessor = OrderProcessor()
    orderProcessor.processOrders()
    orderProcessor.processOrdersWithLabels()
}
