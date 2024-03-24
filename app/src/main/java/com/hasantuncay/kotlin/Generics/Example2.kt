package com.hasantuncay.kotlin.Generics

data class User(val id: Int, val name: String)
data class Product(val id: Int, val name: String, val price: Double)
data class Order(val id: Int, val productId: Int, val quantity: Int)
class ApiRequestHandler<T> {

    fun fetchData(url: String, clazz: Class<T>): T {
        // Burada, gerçekte bir ağ isteği yapıldığını ve gelen JSON verisinin
        // "clazz" parametresi ile belirtilen türe çevrildiğini varsayıyoruz.
        // Bu örnek basitleştirilmiş olup, gerçek bir ağ isteği içermemektedir.
        println("Fetching data from: $url")

        // Sahte veri döndürme
        return when (clazz.simpleName) {
            "User" -> User(1, "John Doe") as T
            "Product" -> Product(1, "Laptop", 999.99) as T
            "Order" -> Order(1, 1, 2) as T
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }
}
fun main() {
    val userHandler = ApiRequestHandler<User>()
    val user = userHandler.fetchData("api/users/1", User::class.java)
    println(user)

    val productHandler = ApiRequestHandler<Product>()
    val product = productHandler.fetchData("api/products/1", Product::class.java)
    println(product)

    val orderHandler = ApiRequestHandler<Order>()
    val order = orderHandler.fetchData("api/orders/1", Order::class.java)
    println(order)
}
