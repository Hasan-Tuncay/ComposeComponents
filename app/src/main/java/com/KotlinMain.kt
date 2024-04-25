
//fun faktoriyel(n: Int): Int {
//    println("Faktöriyel çağrılıyor: n=$n")
//    if (n <= 1) {
//        return 1
//    } else {
//        return n * faktoriyel(n - 1)
//    }
//}
fun faktoriyel(n: Int): Int {
    println("call faktoriyel($n)")
    if (n == 0) {
        println("return 1")
        return 1 // En alt basamak, sonuç 1 olarak dönüyor.
    } else {
        val sonuc = n * faktoriyel(n - 1)
        println("return $sonuc")
        return sonuc
    }
}

tailrec fun faktoriyelTailRec(n: Int, birikim: Int = 1): Int {
    println("FaktöriyelTailRec çağrılıyor: n=$n, birikim=$birikim")
    if (n <= 1) {
        return birikim
    } else {
        return faktoriyelTailRec(n - 1, n * birikim)
    }
}

fun main() {


    faktoriyel(5)
    faktoriyelTailRec(5)
}

