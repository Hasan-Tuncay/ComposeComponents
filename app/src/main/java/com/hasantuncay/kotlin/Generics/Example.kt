package com.hasantuncay.kotlin.Generics
/**
Kotlin'de jenerikler, farklı türlerle çalışabilen parametrelendirilmiş türler oluşturmanızı sağlar.
Bu, özellikle koleksiyon sınıfları gibi farklı türdeki nesneleri tutmanız gereken durumlar için kullanışlıdır.
Aşağıda, GenericHolder, AnyHolder, ve jenerik fonksiyonların kullanımına dair kapsamlı örnekler sunulmaktadır:

GenericHolder Sınıfı
Bu örnekte, T jenerik parametresi kullanılarak herhangi bir türdeki bir değeri tutan bir sınıf tanımlanmıştır.
Bu sayede, GenericHolder sınıfı farklı türlerdeki nesneleri tutabilir.

*/
class Dog(){
    fun bark():String{
       return "Hello Generic Dog"
    }
}
class GenericHolder<T>(private val value: T) {
    fun getValue(): T = value
}

//fun main() {
//    val carHolder = GenericHolder(Automobile("Ford"))
//    println(carHolder.getValue()) // Automobile(brand=Ford)
//
//    val intHolder = GenericHolder(42)
//    println(intHolder.getValue()) // 42
//
//    val stringHolder = GenericHolder("Kotlin")
//    println(stringHolder.getValue()) // Kotlin
//}

/**
 * AnyHolder Sınıfı
 * Any türünü kullanarak herhangi bir türdeki değeri tutan bir sınıf. Ancak bu yaklaşım, nesnenin asıl türüne özgü işlemleri yapmanızı engeller.
 *
 * */


class AnyHolder(private val value: Any) {
    fun getValue(): Any = value
}
//
//fun main() {
//    val dogHolder = AnyHolder(Dog())
//    val any = dogHolder.getValue()
//    // any.bark() // Hata: bark() metodu Any türünde tanımlı değil.
//}
/**
 * Jenerik Fonksiyon
Belirli bir türdeki bir argümanı alıp aynı türde bir değer döndüren jenerik bir fonksiyon örneği:
 */

fun <T> identity(arg: T): T = arg

fun main() {
    println(identity("Yellow")) // Yellow
    println(identity(1)) // 1

    val d: Dog = identity(Dog())
    println(d.bark()) // Ruff!
}
/**
 * Jenerik Koleksiyon Uzantı Fonksiyonları
 * Kotlin standart kütüphanesi, koleksiyonlar için birçok jenerik uzantı fonksiyonu içerir. Bu fonksiyonlar, herhangi bir türdeki List ile çalışabilir.
 *
 * */


fun <T> List<T>.firstOrThrow(): T {
    if (isEmpty()) throw NoSuchElementException("Empty List")
    return this[0]
}

fun <T> List<T>.firstOrNullSafe(): T? = if (isEmpty()) null else this[0]

//fun main() {
//    val numbers = listOf(1, 2, 3)
//    println(numbers.firstOrThrow()) // 1
//    println(numbers.firstOrNullSafe()) // 1
//
//    val emptyList = listOf<String>()
//    println(emptyList.firstOrNullSafe()) // null
//}
