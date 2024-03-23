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