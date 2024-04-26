package com.hasantuncay.kotlin.OOP

/**
 * Kotlin'de fonksiyonları yazarken expression body ve block body olmak üzere iki farklı şekilde tanımlama yapabilirsiniz. Bunlar arasındaki farklar ve örneklerle açıklama şöyle:
 *
 * ### 1. Expression Body
 *
 * - **Expression Body** kullanıldığında, fonksiyon tek bir ifade ile tanımlanır ve bu ifade fonksiyonun dönüş değeridir. Fonksiyonun sonucu bu ifade tarafından doğrudan belirlenir. Örneğin:
 *
 *   ```kotlin
 *   fun f() = 2323
 *   fun g() = "ch = $ch; f() = ${f()}"
 *   ```
 *
 *   Burada `fun g()` fonksiyonu, `"ch = $ch; f() = ${f()}"` string ifadesini döndürür. `$ch` ve `${f()}`, string içerisinde dinamik olarak değerlendirilir. `ch` değişkeni tanımlı olmalıdır, yoksa bir hata alırsınız.
 *
 * ### 2. Block Body
 *
 * - **Block Body** kullanıldığında, fonksiyonun gövdesi süslü parantezler `{}` içine alınır. Bu tür fonksiyonlar, birden fazla işlem içerebilir ve `return` anahtar kelimesi ile sonuç döndürebilir. Eğer fonksiyon bir değer döndürmeyecekse `return` anahtar kelimesine gerek yoktur (Unit fonksiyonlar). Örneğin:
 *
 *   ```kotlin
 *   fun g(): String {
 *       return "ch = $ch; f() = ${f()}"
 *   }
 *   ```
 *
 *   Bu örnekte, `fun g()` fonksiyonu bir string döndürür ve gövdesi `{}` içerisinde tanımlanmıştır. Burada, fonksiyon birden fazla işlem yapabilir, ancak bu örnekte sadece bir `return` ifadesi kullanılmıştır.
 *
 * ### İkisinin Karşılaştırılması
 *
 * - **Expression Body** daha sade ve tek satırda sonucu ifade eden durumlar için idealdir.
 * - **Block Body** daha karmaşık mantıkları veya birden fazla adımı barındıran fonksiyonlar için daha uygundur.
 *
 * `"ch = $ch; f() = ${f()}"` ifadesini düz bir fonksiyon olarak yazmak için şu şekilde bir **Block Body** kullanabilirsiniz:
 *
 * ```kotlin
 * fun g(): String {
 *     val ch = 'A'  // Örnek bir karakter değeri
 *     return "ch = $ch; f() = ${f()}"
 * }
 * ```
 *
 * Burada `ch` değişkeni önce tanımlanmış ve sonra kullanılmıştır. Eğer `ch` değişkeninin değerini dinamik olarak dışarıdan almak isterseniz, fonksiyon parametresi olarak geçebilirsiniz:
 *
 * ```kotlin
 * fun g(ch: Char): String {
 *     return "ch = $ch; f() = ${f()}"
 * }
 * ```
 *
 * Bu şekilde `g` fonksiyonunu çağırırken `ch` için bir değer sağlamalısınız.
 *
 *
 *
 * Evet, verdiğiniz örnekte `ch` özelliği için iki farklı getter tanım şekli gösteriliyor ve her ikisi de Kotlin'deki geçerli syntaxları temsil ediyor. Her iki örnek de `ch` özelliğinin her çağrıldığında `'B'` karakterini döndürmesini sağlar, fakat ifade şekilleri farklıdır:
 *
 * ### 1. Expression Body ile Getter Tanımı
 * Bu şekilde, getter fonksiyonu tek bir ifade ile tanımlanır. Kotlin'de bu tür tanımlama, sonucu doğrudan bir ifade ile vermek için kullanılır:
 * ```kotlin
 * get() = 'B'
 * ```
 * Bu tanım, `get()` fonksiyonunun `'B'` değerini döndüreceğini gösterir. Bu ifade yalnızca bir değer döndürdüğü için çok sade ve açık bir şekildedir.
 *
 * ### 2. Block Body ile Getter Tanımı
 * Bu şekilde, getter fonksiyonu bir kod bloğu içinde tanımlanır. Bu blok `{}` süslü parantezlerle çevrilir ve daha karmaşık hesaplamalar içerebilir. Bir `return` ifadesi kullanılır:
 * ```kotlin
 * get(): Char {
 *     return 'B'
 * }
 * ```
 * Bu tanım da aynı şekilde `get()` fonksiyonunun `'B'` değerini döndüreceğini belirtir. Ancak bu yapı daha fazla kod satırına sahip olup, genellikle daha karmaşık işlemler gerektiğinde tercih edilir.
 *
 * ### Hangi Yöntem Ne Zaman Kullanılır?
 *
 * - **Expression Body**: Kodunuz basit ve tek bir değer dönüşüne odaklanıyorsa, expression body kullanmak daha temiz ve okunması daha kolay bir kod sağlar.
 * - **Block Body**: Eğer getter içinde daha karmaşık işlemler veya birden fazla adım gerekiyorsa, block body kullanmak uygun olur. Ayrıca, birden fazla ifadeyi ve kontrol yapılarını içerebilir.
 *
 * Her iki yöntem de aynı işlevi görür ve Kotlin'de hangi yöntemin kullanılacağı genellikle kişisel veya proje kodlama standartlarına bağlıdır. Simple işlemler için expression body, karmaşık işlemler için block body tercih edilir.
 * */

