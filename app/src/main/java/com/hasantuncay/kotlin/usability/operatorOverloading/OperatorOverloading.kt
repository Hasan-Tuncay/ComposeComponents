package com.hasantuncay.kotlin.usability.operatorOverloading

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}


data class Product(val name: String, val price: Double){
    // Bu fonksiyon + operatörünün Product nesneleri için nasıl çalışacağını tanımlar
    operator fun plus(other: Product): Product {
        // Doğru şekilde string interpolasyonu kullanılarak iki ürünün adlarını birleştiriyoruz.
        val newName =  name + other.name
        val newPrice = price + other.price
        return Product(newName, newPrice)
    }

}

class Sepet(private val ürünler: MutableList<Product> = mutableListOf()) {
    // Sepete ürün eklemek için + operatörünü aşırı yüklüyoruz
    operator fun plus(product: Product): Sepet {
        ürünler.add(product)
        return this
    }

    // Sepetten ürün çıkarmak için - operatörünü aşırı yüklüyoruz
    operator fun minus(product: Product): Sepet {
        ürünler.remove(product)
        return this
    }

    // Sepetteki toplam tutarı hesaplayan fonksiyon
    fun toplamTutar(): Double = ürünler.sumOf { it.price }

    // Sepetin içeriğini gösteren fonksiyon
    override fun toString(): String = ürünler.joinToString(separator = "\n") { "${it.name}: ${it.price}TL" } + "\nToplam Tutar: ${toplamTutar()}TL"

}

data class Zaman(val saat: Int, val dakika: Int) : Comparable<Zaman> {
    // Unary Plus (Identity)
    operator fun unaryPlus() = this

    // Unary Minus
    operator fun unaryMinus() = Zaman(-saat, -dakika)

    // Increment
    operator fun inc(): Zaman {
        val yeniDakika = (dakika + 1) % 60
        val ekSaat = (dakika + 1) / 60
        return Zaman(saat + ekSaat, yeniDakika)
    }

    // Decrement
    operator fun dec(): Zaman {
        val yeniDakika = if (dakika - 1 < 0) 59 else dakika - 1
        val ekSaat = if (dakika - 1 < 0) -1 else 0
        return Zaman(saat + ekSaat, yeniDakika)
    }

    // Plus
    operator fun plus(diğer: Zaman): Zaman {
        val toplamDakika = dakika + diğer.dakika
        val ekSaat = toplamDakika / 60
        return Zaman(saat + diğer.saat + ekSaat, toplamDakika % 60)
    }

    // Minus
    operator fun minus(diğer: Zaman): Zaman {
        val toplamDakika = (dakika - diğer.dakika + 60) % 60
        val ekSaat = (dakika - diğer.dakika) / 60
        return Zaman(saat - diğer.saat + ekSaat, toplamDakika)
    }

    // CompareTo
    override fun compareTo(other: Zaman): Int {
        return when {
            this.saat != other.saat -> this.saat - other.saat
            else -> this.dakika - other.dakika
        }
    }

    // Get (Index Access)
    operator fun get(index: Int): Int = when (index) {
        0 -> saat
        1 -> dakika
        else -> throw IndexOutOfBoundsException("Geçersiz index: $index")
    }

    // Invoke
    operator fun invoke(ekleSaat: Int, ekleDakika: Int): Zaman {
        return this + Zaman(ekleSaat, ekleDakika)
    }

    override fun toString(): String = "${saat.toString().padStart(2, '0')}:${dakika.toString().padStart(2, '0')}"
}

//fun main() {
//
//    var zaman = Zaman(14, 45)
//    println("Orijinal zaman: $zaman")
//
//    zaman++
//    println("Bir dakika sonrası: $zaman")
//
//    zaman--
//    println("Bir dakika öncesi: $zaman")
//
//    val ekZaman = Zaman(2, 30)
//    zaman += ekZaman
//    println("2 saat 30 dakika sonra: $zaman")
//
//    zaman -= ekZaman
//    println("2 saat 30 dakika önce: $zaman")
//
//    val karşılaştırmaZamanı = Zaman(15, 15)
//    println("Zaman ${if (zaman > karşılaştırmaZamanı) "daha sonra" else "daha erken"} $karşılaştırmaZamanı'ndan.")
//
//    println("Saat: ${zaman[0]}, Dakika: ${zaman[1]}")
//
//    zaman = zaman(1, 15) // 1 saat 15 dakika ekler
//    println("Invoke ile 1 saat 15 dakika ekleme: $zaman")
//}
fun main(){
    val p1 = Point(1, 2)
    val p2 = Point(3, 4)
    val p3 = p1 + p2 // Point sınıfı için `+` operatörü kullanılıyor
    println(p3) // Çıktı: Point(x=4, y=6)
    val urun= Product("Hasan",1.4)
    val urun2= Product("Esra",2.3)
    val sum = urun + urun2
    println("nesne toplam: $sum")

}
//fun main() {
//
//    // Ürünlerin oluşturulması
//    val kitap = Ürün("Kotlin Programlama Dili", 59.99)
//    val mouse = Ürün("Oyun Mouse'u", 249.90)
//    val klavye = Ürün("Mekanik Klavye", 499.50)
//
//    // Yeni bir sepet oluşturuluyor
//    var sepet = Sepet()
//
//    // Sepete ürünler ekleniyor
//    sepet += kitap
//    sepet += mouse
//    sepet += klavye
//
//    println("Sepete Ekleme Sonrası: \n$sepet")
//
//    // Sepetten bir ürün çıkarılıyor
//    sepet -= mouse
//
//    println("\nSepetten Çıkarma Sonrası: \n$sepet")
//}

/**
Kotlin'de operator overloading, belirli operatörleri belirlenmiş isimlere sahip fonksiyonlarla ilişkilendirerek,
bu operatörlerin davranışlarını kullanıcı tanımlı tipler için özelleştirmenize olanak tanır.
Kotlin, bir dizi operatör için bu özelliği destekler. İşte kullanabileceğiniz operatörler ve ilişkilendirdikleri fonksiyon isimleri:

Unary Prefix Operatörleri
+a için unaryPlus()
-a için unaryMinus()
!a için not()
Increment ve Decrement
a++ veya ++a için inc()
a-- veya --a için dec()
Binary Operatörler
a + b için plus(b)
a - b için minus(b)
a * b için times(b)
a / b için div(b)
a % b için rem(b), Kotlin 1.1'den itibaren mod(b) yerine rem(b) kullanılır.
a..b için rangeTo(b)
'in' Operatörü
a in b için contains(a)
a !in b için contains(a) fonksiyonunun sonucunun tersi
Index Access Operatörleri
a[i] için get(i)
a[i] = b için set(i, b)
Invoke Operatörü
a() için invoke(), invoke fonksiyonu birden fazla parametre alabilir.
Assignment Operatörleri
a += b için plusAssign(b)
a -= b için minusAssign(b)
a *= b için timesAssign(b)
a /= b için divAssign(b)
a %= b için remAssign(b)
Equality ve Comparison Operatörleri
a == b ve a != b için Kotlin, equals(b) fonksiyonunu kullanır. Ancak, bu fonksiyonun operator anahtar kelimesi ile işaretlenmesi gerekmez.
a > b, a < b, a >= b, a <= b için sırasıyla compareTo(b) fonksiyonu kullanılır ve bu fonksiyon 0'dan büyük,
küçük veya eşit değerler döndürerek karşılaştırmayı sağlar.
Operator overloading kullanırken, Kotlin'in type safety ve clear code yazımı prensiplerine uygun hareket etmek önemlidir.
Bu operatörlerin kullanımı, kodun okunabilirliğini ve ifade gücünü artırabilir, ancak aşırı ve yanıltıcı kullanımları karışıklığa yol açabilir.
Bu yüzden, operatör overloading'i mantıklı ve anlaşılır durumlar için kullanmak en iyisidir.

*/




