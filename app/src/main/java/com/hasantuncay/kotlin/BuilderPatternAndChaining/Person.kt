package com.hasantuncay.kotlin.BuilderPatternAndChaining

class Person {
    var name: String = ""
    var age: Int = 0

    fun name(name: String): Person {
        this.name = name
        return this
    }

    fun age(age: Int): Person {
        this.age = age
        return this
    }

    fun introduce() {
        println("Merhaba, benim adım $name ve yaşım $age.")
    }
}
fun main() {
    val person = Person()
    person.name("Ahmet")
        .age(25)
        .introduce()
    // Çıktı: Merhaba, benim adım Ahmet ve yaşım 25.
}
