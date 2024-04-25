package com.hasantuncay.kotlin

//import kotlin.reflect.KMutableProperty
//import kotlin.reflect.full.memberProperties
//import kotlin.reflect.jvm.isAccessible
//
//inline fun <reified T : Any> initializeObjectWithDefaults(obj: T?): T {
//    val instance = obj ?: T::class.constructors.firstOrNull()?.call()
//    ?: throw IllegalArgumentException("Sınıf için uygun bir constructor bulunamadı.")
//
//    T::class.members  .forEach { prop ->
//        if (prop is KMutableProperty<*>) {
//            prop.isOpen = true // Erişilebilirliği aç
//            val currentValue = prop.get(instance)
//            if (currentValue == null) {
//                // Kotlin'in temel veri tipleri için varsayılan değerleri atayın
//                val defaultValue: Any? = when (prop.returnType.classifier) {
//                    String::class -> ""
//                    Int::class -> 0
//                    Long::class -> 0L
//                    Short::class -> 0.toShort()
//                    Byte::class -> 0.toByte()
//                    Double::class -> 0.0
//                    Float::class -> 0f
//                    Boolean::class -> false
//                    Char::class -> '\u0000'
//                    // Koleksiyonlar ve diziler için varsayılan boş yapılar
//                    List::class -> emptyList<Any?>()
//                    Set::class -> emptySet<Any?>()
//                    Map::class -> emptyMap<Any?, Any?>()
//                    Array::class -> arrayOf<Any?>()
//                    // Diğer özel tipler için daha fazla durum ekleyebilirsiniz
//                    else -> null
//                }
//                defaultValue?.let { prop.setter.call(instance, it) }
//            }
//        }
//    }
//
//    return instance
//}
fun main() {
    // List için maxBy kullanımı - Elemanın karesine göre en büyük değeri bulma
    val sayilarListesi = listOf(1, 2, 3, 4, 5).asSequence()
    val enBuyukKareSayi = sayilarListesi.minByOrNull { it * it } // Elemanın karesi
    println("Listedeki en büyük kareye sahip sayı: $enBuyukKareSayi") // Çıktı: Listedeki en büyük kareye sahip sayı: 5

    // Set için maxBy kullanımı - Elemanın tersine göre en büyük değeri bulma
    val karelerSeti = setOf(1, 4, 9, 16, 25)
    val enKucukTersKare = karelerSeti.maxByOrNull { -it } // Negatif değer, küçükten büyüğe sıralama yapar
    println("Setteki en küçük karenin tersi olarak düşündüğümüzde en büyük kare: $enKucukTersKare") // Çıktı: Setteki en küçük karenin tersi olarak düşündüğümüzde en büyük kare: 1

    // Map için maxBy kullanımı - Anahtarın uzunluğuna göre en uzun anahtara sahip çifti bulma
    val isimYasMap = mapOf("Alice" to 30, "Bob" to 25, "Christopher" to 35)
    val enUzunIsimliKisi = isimYasMap.maxBy { it.key.length } // Anahtarın (ismin) uzunluğu
    println("En uzun isme sahip kişi: ${enUzunIsimliKisi?.key}, Yaş: ${enUzunIsimliKisi?.value}")
    // Çıktı: En uzun isme sahip kişi: Christopher, Yaş: 35
}
