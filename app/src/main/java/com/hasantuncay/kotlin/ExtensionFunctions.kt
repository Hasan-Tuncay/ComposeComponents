package com.hasantuncay.kotlin
/**
### Interface by Convention ve Extension Functions Üzerine Bir İnceleme

#### Özet
Bu çalışma, Kotlin programlama dilindeki "interface by convention" ve "extension functions" kavramlarını incelemekte ve
bu tekniklerin Kotlin kütüphanelerinde nasıl kullanıldığını örneklerle göstermektedir. Ayrıca,
bu yaklaşımın Java koleksiyonları ile olan uyumluluğu ve Kotlin felsefesi içerisindeki yeri tartışılmaktadır.

#### 1. Giriş
Kotlin, statik tip sistemi olan modern bir programlama dilidir ve Java ile uyumlu olarak çalışır.
Kotlin'in getirdiği yeniliklerden biri de "extension functions" ve "interface by convention" yaklaşımlarıdır.
Bu çalışma, söz konusu kavramların teknik detaylarını ve pratik uygulamalarını ele almakta, Kotlin'in fonksiyonel programlama özelliklerini nasıl geliştirdiğini açıklamaktadır.

#### 2. Interface by Convention ve Extension Functions
"Interface by Convention" (Sözleşme ile Arayüz), Kotlin'de, belirli fonksiyonların sınıflara eklenmesiyle implicit olarak oluşturulan sözleşmelerdir.
Bu yaklaşım, aynı fonksiyonun farklı sınıflarda farklı implementasyonları olduğunda kullanışlıdır. Özellikle, koleksiyonlar gibi yapılar üzerinde işlemler gerçekleştirirken bu yöntem tercih edilir.

"Extension functions" (Genişletme Fonksiyonları), bir sınıfa yeni metodlar eklemek için kullanılan bir tekniktir.
Bu metodlar, ana sınıfın kodunu değiştirmeden sınıfa fonksiyonellik ekler. Extension functions,
"interface by convention" yaklaşımının bir parçası olarak düşünülebilir.

#### 3. Kod Örneği ve Açıklama

```kotlin
// Kotlin'deki extension function örneği
package inheritanceextensions

class X  // Basit bir sınıf tanımı
class Y  // Başka bir basit sınıf tanımı

// X sınıfı için extension function tanımlaması
fun X.f() {
    println("X sınıfının f fonksiyonu çağrıldı.")
}

// Y sınıfı için extension function tanımlaması
fun Y.f() {
    println("Y sınıfının f fonksiyonu çağrıldı.")
}

// X türündeki nesneler için f fonksiyonunu çağıran fonksiyon
fun callF(x: X) = x.f()

// Y türündeki nesneler için f fonksiyonunu çağıran fonksiyon
fun callF(y: Y) = y.f()

fun main() {
    val x = X()  // X sınıfından bir nesne oluşturuluyor
    val y = Y()  // Y sınıfından bir nesne oluşturuluyor
    x.f()  // X nesnesi için f çağrılıyor
    y.f()  // Y nesnesi için f çağrılıyor
    callF(x)  // callF fonksiyonu X nesnesi ile çağrılıyor
    callF(y)  // callF fonksiyonu Y nesnesi ile çağrılıyor
}
```

**Kod Açıklaması:**
Bu kod bloğu, `X` ve `Y` sınıflarına ait nesneler için `f()` fonksiyonunun nasıl tanımlandığını ve kullanıldığını göstermektedir.
Her iki sınıf için de `f()` fonksiyonu ayrı ayrı tanımlanmış ve bu fonksiyonlar ilgili nesneler üzerinde çağrıldığında farklı çıktılar üretmektedir.
Bu, "interface by convention" yaklaşımının tipik bir kullanımıdır, çünkü `f()` fonksiyonu her iki sınıf için de bir arayüz gibi davranmaktadır anc

ak polimorfik davranış sergilemez.

#### 4. Sonuç
Kotlin'de "interface by convention" ve "extension functions" kullanımı, programlamayı daha esnek ve ifade gücü yüksek hale getirir.
Özellikle fonksiyonel programlama özelliklerini güçlendirmek ve mevcut Java ekosistemine yeni özellikler eklemek için bu özellikler etkili bir
şekilde kullanılmaktadır. Ancak, bu tekniklerin doğru ve uygun yerlerde kullanılması, yazılımın bakımını ve
anlaşılabilirliğini artırırken aynı zamanda potansiyel hataları da minimize eder.
        */