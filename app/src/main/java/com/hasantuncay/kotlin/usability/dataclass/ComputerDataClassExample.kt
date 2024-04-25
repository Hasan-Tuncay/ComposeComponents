package com.hasantuncay.kotlin.usability.dataclass

data class Computer(
    val processor: String,
    val ram: Int,
    val storage: Int,
    val graphicsCard: String? = null // Optional
) {
    // Companion object to act as a builder
    companion object Builder {
        private var processor: String = "Intel i5"
        private var ram: Int = 8
        private var storage: Int = 256
        private var graphicsCard: String? = null

        fun processor(processor: String) = apply { Builder.processor = processor }
        fun ram(ram: Int) = apply { Builder.ram = ram }
        fun storage(storage: Int) = apply { Builder.storage = storage }
        fun graphicsCard(graphicsCard: String?) = apply { Builder.graphicsCard = graphicsCard }

        fun build() = Computer(processor, ram, storage, graphicsCard)

        // Reset builder to default values after each build
        fun reset() {
            processor = "Intel i5"
            ram = 8
            storage = 256
            graphicsCard = null
        }
    }
}

fun main() {
    val gamingComputer = Computer.build()

    println(gamingComputer)

    // Resetting the Builder to demonstrate the capability
    Computer.reset()

    val officeComputer = Computer.build()

    println(officeComputer)
}
