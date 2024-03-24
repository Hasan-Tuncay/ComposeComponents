package com.hasantuncay.kotlin

import kotlin.reflect.KMutableProperty
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

inline fun <reified T : Any> initializeObjectWithDefaults(obj: T?): T {
    val instance = obj ?: T::class.constructors.firstOrNull()?.call()
    ?: throw IllegalArgumentException("Sınıf için uygun bir constructor bulunamadı.")

    T::class.members  .forEach { prop ->
        if (prop is KMutableProperty<*>) {
            prop.isOpen = true // Erişilebilirliği aç
            val currentValue = prop.get(instance)
            if (currentValue == null) {
                // Kotlin'in temel veri tipleri için varsayılan değerleri atayın
                val defaultValue: Any? = when (prop.returnType.classifier) {
                    String::class -> ""
                    Int::class -> 0
                    Long::class -> 0L
                    Short::class -> 0.toShort()
                    Byte::class -> 0.toByte()
                    Double::class -> 0.0
                    Float::class -> 0f
                    Boolean::class -> false
                    Char::class -> '\u0000'
                    // Koleksiyonlar ve diziler için varsayılan boş yapılar
                    List::class -> emptyList<Any?>()
                    Set::class -> emptySet<Any?>()
                    Map::class -> emptyMap<Any?, Any?>()
                    Array::class -> arrayOf<Any?>()
                    // Diğer özel tipler için daha fazla durum ekleyebilirsiniz
                    else -> null
                }
                defaultValue?.let { prop.setter.call(instance, it) }
            }
        }
    }

    return instance
}
