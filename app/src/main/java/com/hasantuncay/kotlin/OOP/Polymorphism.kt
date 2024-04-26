package com.hasantuncay.kotlin.OOP

 open class Pet {
    open fun speak() = "Pet"
}

class Dog : Pet() {
    override fun speak() = "Bark!"
}

class Cat : Pet() {
    override fun speak() = "Meow"
}

fun talk(pet: Pet) = pet.speak()

fun main() {
     talk(Dog()) // "Bark!"     // [1]
    talk(Cat()) //"Meow"      // [2]”


}
/**“Notice the talk() function parameter. When passing a Dog or a Cat to
talk(), the specific type is forgotten and becomes a plain Pet—both
Dogs and Cats are upcast to Pet. The objects are now treated as
plain Pets so shouldn’t the output for both lines [1] and [2] be
"Pet"?”

“Polymorphism occurs when a parent class reference contains a child class
instance. When you call a member on that parent class reference, polymorphism
produces the correct overridden member from the child class.”

 * */


