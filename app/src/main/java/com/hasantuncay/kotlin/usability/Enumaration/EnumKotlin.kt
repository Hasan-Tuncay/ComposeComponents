package com.hasantuncay.kotlin.usability.Enumaration

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.function.BinaryOperator
import java.util.function.IntBinaryOperator

enum class TrafficLight(val color: String, val action: String, protected val waitTime: Int) {
    RED("Kırmızı", "Dur", 60) {
        override fun signal() = "Durma süreniz: $waitTime saniye."
    },
    YELLOW("Sarı", "Dikkat", 5) {
        override fun signal() = "Hazır olun, $waitTime saniye içinde değişecek."
    },
    GREEN("Yeşil", "Git", 60) {
        override fun signal() = "Yolunuz açık! $waitTime saniye boyunca geçebilirsiniz."
    };

    abstract fun signal(): String

    companion object {
        fun fromColor(color: String): TrafficLight? {
            return values().find { it.color == color }
        }
    }

    fun displayAction() {
        println("$color ışıkta yapılması gereken: $action")
    }

    fun displaySignalMessage() {
        println(signal())
    }
}

enum class Direction {
    NORTH {
        override fun description() = "Yön Kuzey"
    },
    SOUTH {
        override fun description() = "Yön Güney"
    },
    WEST {
        override fun description() = "Yön Batı"
    },
    EAST {
        override fun description() = "Yön Doğu"
    };

    abstract fun description(): String
}

//sampleStart
@RequiresApi(Build.VERSION_CODES.N)
enum class IntArithmetics : BinaryOperator<Int>, IntBinaryOperator { PLUS {
    override fun apply(t: Int, u: Int): Int = t + u },
    TIMES {
        override fun apply(t: Int, u: Int): Int = t * u
    };
    override fun applyAsInt(t: Int, u: Int) = apply(t, u) }
//sampleEnd


fun main() {
    val currentLight = TrafficLight.GREEN
    currentLight.displayAction()
    currentLight.displaySignalMessage()

    val lightFromColor = TrafficLight.fromColor("Sarı")
    lightFromColor?.displayAction()
    lightFromColor?.displaySignalMessage()

//    values() Metodu
//            values() metodu, enum sınıfındaki tüm sabitleri içeren bir dizi döndürür.
//            Bu, enum sabitlerini döngü ile işlemek için kullanışlıdır.
    // Tüm TrafficLight sabitlerini yazdırma
    TrafficLight.values().forEach { light ->
        println(light)
    }

//    valueOf(String name) Metodu
//            valueOf() metodu, verilen adı taşıyan enum sabitini döndürür. Bu metod büyük/küçük harfe duyarlıdır ve
//            eşleşen bir sabit bulamazsa IllegalArgumentException fırlatır.
//
// "RED" adına sahip TrafficLight sabitini alır
    val redLight = TrafficLight.valueOf("RED")
    println(redLight)


    val a = 13
    val b = 31
    for (f in if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        IntArithmetics.values()
    } else {
        TODO("VERSION.SDK_INT < N")
    }) {
        println("$f($a, $b) = ${f.apply(a, b)}")
    }
    //1.9.0 dan sonra
    for (color in TrafficLight.entries) println(color.toString())
    println(TrafficLight.GREEN.name)// GREEN
    println(TrafficLight.GREEN.ordinal)//2
}


