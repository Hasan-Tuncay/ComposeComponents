package com.hasantuncay.kotlin.nullable
/**

### Non-Nullable Değişken ve Dereferencing

 */
fun nonNullable(){
    val nonNullableString: String = "Hello, Kotlin"
// 'nonNullableString' bir referanstır; 'String' tipinde bir nesneyi işaret eder.

// Dereferencing:
// 'nonNullableString' üzerinden '.length' özelliğine erişim.
// Bu, 'nonNullableString' referansının işaret ettiği nesnenin 'length' özelliğine erişmek anlamına gelir.
    val length = nonNullableString.length
    println("Length of nonNullableString: $length")
//Bu örnekte, `nonNullableString` değişkeni `String` tipinde bir nesneyi referans eder. `.length` özelliğine erişim,
//bu referansın işaret ettiği nesnenin bir üyesine erişmek anlamına gelir ve bu işleme dereferencing denir.

}




/**
### Nullable Değişken ve Güvenli Dereferencing

 */
 fun nullable(){
    val nullableString: String? = "Optional String"
// 'nullableString' bir referanstır; 'String?' tipinde bir nesneyi işaret eder ve bu nesne null olabilir.

// Güvenli Dereferencing:
// 'nullableString' üzerinden güvenli çağrı operatörü '?.'
// kullanılarak '.length' özelliğine erişim.
// Eğer 'nullableString' null değilse, bu, 'nullableString' referansının işaret ettiği nesnenin 'length'
// özelliğine güvenli bir şekilde erişmek anlamına gelir.
    val lengthOrNull = nullableString?.length
    println("Length of nullableString: $lengthOrNull")

//
//    Bu örnekte, `nullableString` değişkeni null olabilen (`String?` tipinde) bir nesneyi referans eder. `nullableString?.length`
//    ifadesi, `nullableString` referansının işaret ettiği nesnenin `length` özelliğine güvenli bir şekilde erişmek için kullanılan
//    bir dereferencing yöntemidir. Burada, `?.` operatörü, `nullableString`'in null olup olmadığını kontrol eder ve eğer null değilse,
//    dereferencing yapar; yani, referansın işaret ettiği nesnenin `length` özelliğine erişir.

}
/**
### Özet

- **Referans:** Bir değişken, bellekteki bir nesneyi işaret eder; bu, bir referanstır.
- **Dereferencing:** Bir referans üzerinden nesnenin bir üyesine (fonksiyonu, özelliği vb.) erişmek, dereferencing işlemidir.
- Kotlin'de, nullable değişkenler için güvenli çağrı operatörü (`?.`) kullanılarak güvenli dereferencing yapılır. Bu, nullable bir
referansın null olup olmadığını kontrol eder ve sadece null değilse üye erişimine izin verir.
        */



/**
 * Bu Kotlin dosyası, nullable tipler, güvenli çağrılar (safe calls),
 * Elvis operatörü, non-null iddiaları ve nullable tipler için
 * genişletme fonksiyonları gibi konseptleri örneklerle açıklar.
 */

// Nullable türler için örnek bir class
class ExampleClass {
    var exampleProperty: String? = null // Bu özellik nullable bir String türündedir.
}

fun main() {
    // Nullable ve non-nullable değişken tanımlamaları
    val nonNullableString: String = "Hello Kotlin"
    val nullableString: String? = null

    // Güvenli çağrılar (Safe Calls) kullanımı
    // `nullableString` null olabileceği için güvenli çağrı operatörü `?.` kullanıyoruz.
    println(nullableString?.length) // null döndürür, çünkü `nullableString` null'dır.

    // Elvis Operatörü kullanımı
    // `nullableString`'in uzunluğunu kontrol eder, null ise 0 döndürür.
    val length: Int = nullableString?.length ?: 0
    println("String length: $length")

    // Non-null iddiaları (Non-Null Assertions) kullanımı
    // DİKKAT: `!!` operatörü, değişkenin kesinlikle null olmadığını iddia eder.
    // Eğer değişken null ise, bir NullPointerException fırlatır.
    // println(nullableString!!.length) // Bu satır NullPointerException fırlatır.

    // Nullable tipler için genişletme fonksiyonları
    // `isNullOrEmpty` ve `isNullOrBlank`, Kotlin standart kütüphanesi tarafından sağlanan
    // genişletme fonksiyonlarıdır ve nullable String'ler için güvenli bir şekilde kullanılabilir.
    println("Is null or empty: ${nullableString.isNullOrEmpty()}")
    println("Is null or blank: ${nullableString.isNullOrBlank()}")

    // Nullable tipler ve map üzerinde çalışmak
    val map = mapOf(1 to "Kotlin", 2 to "Java")
    val result: String? = map[3] // map'de 3 anahtarı yok, bu yüzden null döner.
    println("Map result: ${result ?: "Key not found"}") // Elvis operatörü ile key kontrolü
}

/**
 * Nullable String türleri için `isNullOrEmpty` genişletme fonksiyonunun nasıl
 * yazılabileceğini gösteren bir örnek.
 */
fun String?.isNullOrEmpty(): Boolean {
    return this == null || this.isEmpty()
}

/**
 * Nullable String türleri için `isNullOrBlank` genişletme fonksiyonunun nasıl
 * yazılabileceğini gösteren bir örnek.
 */
fun String?.isNullOrBlank(): Boolean {
    return this == null || this.isBlank()
}
