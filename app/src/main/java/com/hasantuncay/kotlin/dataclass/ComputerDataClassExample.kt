package com.hasantuncay.kotlin.dataclass

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

        fun processor(processor: String) = apply { this.processor = processor }
        fun ram(ram: Int) = apply { this.ram = ram }
        fun storage(storage: Int) = apply { this.storage = storage }
        fun graphicsCard(graphicsCard: String?) = apply { this.graphicsCard = graphicsCard }

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
    val gamingComputer = Computer.Builder
        .processor("AMD Ryzen 9")
        .ram(32)
        .storage(1024)
        .graphicsCard("NVIDIA RTX 3080")
        .build()

    println(gamingComputer)

    // Resetting the Builder to demonstrate the capability
    Computer.Builder.reset()

    val officeComputer = Computer.Builder
        .processor("Intel i7")
        .build()

    println(officeComputer)
}
