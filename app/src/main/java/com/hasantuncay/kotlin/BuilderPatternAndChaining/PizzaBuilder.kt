package com.hasantuncay.kotlin.BuilderPatternAndChaining
class Pizza private constructor(
    val size: Size,
    val toppings: List<Topping>,
    val crustType: CrustType
) {
    enum class Size { SMALL, MEDIUM, LARGE }
    enum class Topping { CHEESE, PEPPERONI, MUSHROOMS, ONIONS }
    enum class CrustType { THIN, THICK, STUFFED }

    class Builder(
        private var size: Size = Size.MEDIUM, // Default size
        private var crustType: CrustType = CrustType.THIN // Default crust
    ) {
        private val toppings: MutableList<Topping> = mutableListOf()

        fun size(size: Size) = apply { this.size = size }
        fun crustType(crustType: CrustType) = apply { this.crustType = crustType }
        fun addTopping(topping: Topping) = apply { this.toppings.add(topping) }
        fun build() = Pizza(size, toppings, crustType)
    }

    override fun toString(): String {
        return "Pizza(size=$size, crustType=$crustType, toppings=${toppings.joinToString()})"
    }
}

fun main() {
    val pizzaOrder = Pizza.Builder()
        .size(Pizza.Size.LARGE)
        .crustType(Pizza.CrustType.STUFFED)
        .addTopping(Pizza.Topping.CHEESE)
        .addTopping(Pizza.Topping.PEPPERONI)
        .build()

    println("Your pizza order: $pizzaOrder")
}
