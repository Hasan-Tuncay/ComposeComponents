package com.hasantuncay.kotlin.OOP

abstract class AbstractClasses {
    /**
     *
     *
     * */
    val integer: Int
        get() {
            TODO()
        }
    abstract val double: Double

    abstract fun square(): Int
    fun double() {}
}

/**
 *“All functions and properties declared in an interface are abstract by default,
 * which makes an interface similar to an abstract class. When an interface
 * contains a function or property declaration, the abstract modifier is
 * redundant and can be removed. These two interfaces are equivalent:”
 * interface icinde declare dilen butun degiskenler ve fonksiyonlar halihazirda  abstract dir. abstract modifier i gereksizdir.

 *
 * */
interface Redundant {
    abstract val x: Int
    abstract fun f(): Int
    abstract fun g(n: Double)
}

interface Removed {
    val x: Int
    fun f(): Int
    fun g(n: Double)
}

/**
 *abstract class ile  interface in temel farki state dir. interfaceler dtate tutamaz abstract siniflar tutabilir.
 * birinterface de degisken declare etseniz bile  bu deger  interface de degil   onu implemende eden sinifta tutulur.
 *
 * Aşağıda, interface'ler ve abstract sınıfların Kotlin ve Java programlama dillerindeki kullanımları, benzerlikleri ve farklılıkları üzerine daha detaylı ve düzenlenmiş bir inceleme sunulmaktadır. Her kavramın açıklaması sonrasında hem Kotlin hem de Java dillerinde örnekler verilmiştir. Ayrıca, ilgili yazılım kavramlarının İngilizce terimleri parantez içinde verilmiştir.
 *
 * ### Benzerlikler
 *
 * 1. **Soyutlama Sağlama (Abstraction):**
 *    Hem interface'ler hem de abstract sınıflar, belirli bir sınıfın veya interface'in hangi metodlara (methods) sahip olacağını tanımlamanıza olanak tanır, ancak bu metodların nasıl implemente edileceğini (implemented) belirtmezsiniz (interface'lerde default metodlar hariç).
 *
 *    - **Java Örneği:**
 *      ```java
 *      interface Movable {
 *          void move();  // Soyut metod, implementasyonu zorunlu
 *      }
 *
 *      abstract class Vehicle {
 *          abstract void start();  // Soyut metod, implementasyonu türetilmiş sınıfta zorunlu
 *      }
 *      ```
 *
 *    - **Kotlin Örneği:**
 *      ```kotlin
 *      interface Movable {
 *          fun move()  // Soyut metod, implementasyonu zorunlu
 *      }
 *
 *      abstract class Vehicle {
 *          abstract fun start()  // Soyut metod, implementasyonu türetilmiş sınıfta zorunlu
 *      }
 *      ```
 *
 * 2. **Polimorfizm (Polymorphism):**
 *    Her iki yapı da çeşitli sınıfların aynı interface'i implemente edebilmesini veya bir abstract sınıftan türeyebilmesini sağlayarak polimorfizm özelliği sunar.
 *
 *    - **Java Örneği:**
 *      ```java
 *      interface Drawable {
 *          void draw();
 *      }
 *
 *      abstract class Shape implements Drawable {
 *          abstract void resize();
 *      }
 *
 *      class Circle extends Shape {
 *          void draw() {
 *              System.out.println("Drawing circle.");
 *          }
 *
 *          void resize() {
 *              System.out.println("Resizing circle.");
 *          }
 *      }
 *      ```
 *
 *    - **Kotlin Örneği:**
 *      ```kotlin
 *      interface Drawable {
 *          fun draw()
 *      }
 *
 *      abstract class Shape : Drawable {
 *          abstract fun resize()
 *      }
 *
 *      class Circle : Shape() {
 *          override fun draw() {
 *              println("Drawing circle.")
 *          }
 *
 *          override fun resize() {
 *              println("Resizing circle.")
 *          }
 *      }
 *      ```
 *
 * ### Farklılıklar
 *
 * 1. **Yöntem Uygulamaları (Method Implementations):**
 *    - **Interface:**
 *      Interface'ler, Java 8 öncesi ve Kotlin'de genellikle herhangi bir yöntem uygulaması içermez; yalnızca metod imzalarını tanımlarlar. Java 8 ve sonrasında ve Kotlin'de, interface'ler default metodlar içerebilir.
 *    - **Abstract Sınıflar:**
 *      Abstract sınıflar, hem tamamlanmamış (abstract) metodlar hem de tamamlanmış (concrete) metodlar içerebilir.
 *
 *    - **Java Örneği:**
 *      ```java
 *      interface Vehicle {
 *          default void printType() {
 *              System.out.println("Unknown Vehicle.");
 *          }
 *      }
 *
 *      abstract class Car {
 *          abstract void drive();
 *
 *          void park() {
 *              System.out.println("Car is parked.");
 *          }
 *      }
 *      ```
 *
 *    - **Kotlin Örneği:**
 *      ```kotlin
 *      interface Vehicle {
 *          fun printType() {
 *              println("Unknown Vehicle.")
 *          }
 *      }
 *
 *      abstract class Car {
 *          abstract fun drive()
 *
 *          fun park() {
 *              println("Car is parked.")
 *          }
 *      }
 *      ```
 *
 * 2. **Çoklu Miras (Multiple Inheritance):**
 *    - **Interface:** Birden fazla interface'i implemente etmek mümkündür, bu da çoklu mirasın bir formudur.
 *    - **Abstract Sınıflar:** Sadece tek bir abstract sınıftan türetilme izni vardır.
 *
 *    - **Java Örneği:**
 *      ```java
 *      interface Flyable {
 *          void fly();
 *      }
 *
 *      interface Readable {
 *          void read();
 *      }
 *
 *      class Drone implements Fly
 *
 * able, Readable {
 *          public void fly() {
 *              System.out.println("Drone flying.");
 *          }
 *
 *          public void read() {
 *              System.out.println("Reading sensor data.");
 *          }
 *      }
 *      ```
 *
 *    - **Kotlin Örneği:**
 *      ```kotlin
 *      interface Flyable {
 *          fun fly()
 *      }
 *
 *      interface Readable {
 *          fun read()
 *      }
 *
 *      class Drone : Flyable, Readable {
 *          override fun fly() {
 *              println("Drone flying.")
 *          }
 *
 *          override fun read() {
 *              println("Reading sensor data.")
 *          }
 *      }
 *      ```
 *
 * 3. **Durum Saklama (State Preservation):**
 *    - **Interface:** Interface'ler genellikle durum (state) saklamaz. Kotlin'de özellikler (properties) tanımlanabilir, ancak arka planda destekleyici alan (backing field) olmadan.
 *    - **Abstract Sınıflar:** Durum saklayabilir ve non-final alanlar içerebilir.
 *
 *    - **Java Örneği:**
 *      ```java
 *      abstract class Animal {
 *          String name;  // Durum bilgisi
 *          abstract void makeSound();
 *      }
 *      ```
 *
 *    - **Kotlin Örneği:**
 *      ```kotlin
 *      abstract class Animal {
 *          var name: String = ""  // Durum bilgisi
 *          abstract fun makeSound()
 *      }
 *      ```
 *
 * ### Kullanım Durumları
 *
 * - **Interface:** Farklı sınıfların aynı işlevleri yerine getirmesini sağlamak ve bu sınıflar arasında bir tür sözleşme (contract) görevi görür.
 * - **Abstract Sınıflar:** Ortak bir temel işlevsellik sağlamak amacıyla kullanılır. Türetilen sınıflar, bazı özellikleri ve metodları miras alırken, abstract metodları kendilerine göre uygulamak zorundadır.
 *
 * Bu detaylı açıklamalar ve örnekler, interface'ler ve abstract sınıflar arasındaki benzerlik ve farklılıkları, ayrıca bu yapıların programlama dillerinde nasıl kullanıldığını daha iyi anlamanızı sağlar.
 * */
interface Parent {
    val ch: Char
    val int: Int
        get() = 5

    fun f(): Int
    fun g() = "ch = $ch; f() = ${f()}" //expression body
    fun gb(): String {
        return "ch = $ch; f() = ${f()}"//blockbody
    }

}

class Actual(
    override val ch: Char        // [1]
) : Parent {
    // [2]
    override fun f() = 4
    override val int: Int
        get() = 3
}

class Other : Parent {
    override val ch: Char        // [3]
        // get() = 'B'
        get() :Char {
            return 'B'
        }

    override fun f() = 34        // [4]
}

fun main() {
    Actual('A').g()
    Other().g()
}
/**Android programlama ve genel olarak yazılım geliştirmede `Impl` takısı, bir sınıf isminin sonunda genellikle "implementation" yani "uygulama" kelimesinin kısaltması olarak kullanılır.
 *  Bu, belirli bir arayüzün veya abstract sınıfın somut (concrete) bir uygulamasını ifade etmek için kullanılır. İsimlendirme biçimi,
 *  arayüzün veya abstract sınıfın fonksiyonlarını gerçekleştiren sınıfın açık bir şekilde tanımlanmasına yardımcı olur. Bu sayede,
 *  kodun okunabilirliği artar ve sınıf hiyerarşisi içerisindeki rolü daha net anlaşılır.

### Ne Zaman Kullanılır?

`Impl` takılı sınıflar, genellikle bir arayüzü veya abstract sınıfı implemente etmek için kullanılır. Bu, tasarım desenlerinde ve
özellikle Dependency Injection gibi konseptlerde sıkça görülür. Arayüzler, bir uygulamanın farklı bölümleri arasında sözleşme sağlarken,
`Impl` sınıfları bu sözleşmeleri yerine getiren somut uygulamalardır.

### Android Özelinde Kullanımı

Android'de `Impl` takısı, çeşitli sistem servislerini ve API uygulamalarını belirtmek için yaygın olarak kullanılır. Android Framework,
birçok arayüz ve abstract sınıf sağlar, ve geliştiriciler veya sistem kendisi bu arayüzleri `Impl` takılı sınıflarla uygular. Örneğin,
bir servis arayüzü için farklı işlevselliklere sahip birden fazla uygulama olabilir, ve her biri farklı bir `Impl` sınıfı olarak tanımlanabilir.

### Örnek

Diyelim ki bir `PropertyAccessor` isimli bir arayüzünüz var ve bu arayüzün farklı şekillerde uygulanması gerekiyor. `Impl` kullanarak,
bu uygulamaları belirgin şekilde isimlendirebilirsiniz:

```java
interface PropertyAccessor {
Object getProperty(String key);
void setProperty(String key, Object value);
}

// PropertyAccessor arayüzünün bir uygulaması
class PropertyAccessorImpl implements PropertyAccessor {
private Map<String, Object> properties = new HashMap<>();

@Override
public Object getProperty(String key) {
return properties.get(key);
}

@Override
public void setProperty(String key, Object value) {
properties.put(key, value);
}
}
```

Bu örnekte, `PropertyAccessorImpl` sınıfı `PropertyAccessor` arayüzünü implemente eder ve gereken metodları somut bir şekilde tanımlar.
Bu yaklaşım, sınıfın neyi gerçekleştirdiği ve hangi arayüzle ilgili olduğu hakkında açık bir bilgi sağlar.

### Sonuç

`Impl` takısı, sınıf isimlerinde kullanıldığında, o sınıfın bir arayüzün veya abstract sınıfın somut bir uygulaması olduğunu belirtir.
Bu, özellikle büyük ve modüler projelerde, kodun daha düzenli ve yönetilebilir olmasını sağlar. Android gibi platformlarda bu tür isimlendirme,
API'ler ve sistem servisleri arasında tutarlılık ve açıklık getirir.
"Contract" terimi veya Türkçe'deki karşılığı "sözleşme", yazılım mühendisliğinde ve özellikle arayüzler (interfaces) bahsi geçtiğinde sıkça kullanılan bir
metafordur. Bu terim, yazılım komponentleri arasındaki etkileşimin belirli kurallar ve şartlar çerçevesinde gerçekleşmesi gerektiğini ifade eder.
Yani, bir arayüzü uygulayan sınıf, arayüz tarafından tanımlanan metod imzalarına (signature) ve bu metodların semantik davranışlarına uygun şekilde hareket etmelidir. İşte bu kavramın mantığı ve önemi:

### 1. **Şeffaflık ve Güven:**
Arayüzler, kodun hangi fonksiyonları sunduğunu açıkça belirtir. Bir arayüzü uygulayan her sınıf, bu fonksiyonları belirli bir şekilde gerçekleştirmeyi
"söz" verir. Bu, arayüzün kullanıldığı yerlerde, sınıfların beklenen işlevleri yerine getireceği konusunda güven oluşturur.

### 2. **Yeniden Kullanım ve Değişiklik Kolaylığı:**
Bir arayüz, farklı sınıflar tarafından farklı şekillerde uygulanabilir, ancak tüm uygulamalar aynı temel fonksiyonları sağlar.
Bu, kodun yeniden kullanılabilirliğini artırır ve sistemin farklı bölümleri arasında kolayca değişiklik yapılmasına olanak tanır.
Örneğin, bir veritabanı erişim arayüzü, farklı veritabanı teknolojileri için farklı sınıflar tarafından uygulanabilir.

### 3. **Dekuplaj (Decoupling):**
Arayüzler, uygulamaları ve kullanımları arasında bir ayrım oluşturarak, kodun bir kısmını diğerinden bağımsız olarak değiştirebilmenizi sağlar.
Bu, sistemlerin daha modüler olmasını sağlar ve bağımlılıkları azaltır.

### 4. **Polimorfizm:**
Arayüzler, farklı sınıfların aynı arayüzü uygulamasına izin vererek, bu sınıfların aynı tür olarak kabul edilmesini sağlar.
Bu sayede, farklı uygulamalar arasında geçiş yapmak veya farklı uygulamaları aynı arayüz altında toplamak mümkün hale gelir.

### 5. **Test Edilebilirlik:**
Arayüzler, birim testlerinde sahte nesneler (mock objects) veya taklit nesneler kullanarak test edilebilirlik sağlar.
Bir arayüzün sahte bir uygulaması, test sırasında gerçek uygulamanın yerine kullanılabilir, böylece testler daha izole ve kontrol edilebilir hale gelir.

### Örnek:
Bir arayüz tanımlayarak ve çeşitli sınıfların bu arayüzü uygulamasını sağlayarak, aynı arayüzü kullanan tüm sınıfların, arayüz tarafından tanımlanan metodları aynı şekilde
(ancak farklı iç uygulamalarla) sunacağı garantisi altında kod yazabilirsiniz. Örneğin, bir "PaymentProcessor"
arayüzü, "CreditCardProcessor" ve "PaypalProcessor" sınıfları tarafından uygulanabilir.
Her iki sınıf da "processPayment" metodunu uygulayacak, ancak her biri ödeme işlemlerini farklı bir ödeme sistemi üzerinden gerçekleştirecektir.

Bu nedenle, "sözleşme" terimi, arayüzlerin kod içinde nasıl işlev gördüğünü ve yazılım geliştirme sürecindeki rol
 */


/*** MULTIPLE INHERTITANCE
 * Çoklu miras (multiple inheritance), bir programlama dilinde bir sınıfın birden fazla üst sınıftan özellikleri ve davranışları miras alabilmesi özelliğidir. Bu yetenek, daha esnek sınıf hiyerarşileri oluşturulmasına imkan tanır. Ancak, çoklu miras bazı dillerde karmaşık sorunlara yol açabileceği için desteklenmezken, bazı dillerde bu özelliği barındırır.
 *
 * ### Çoklu Mirasın Avantajları
 *
 * 1. **Kod Yeniden Kullanımı:** Çoklu miras, farklı sınıflardan özellikleri ve metodları miras alarak yeni sınıflar oluşturmayı kolaylaştırır. Bu, genel kod yeniden kullanımını artırır ve geliştirme sürecini hızlandırır.
 *
 * 2. **Esneklik:** Geliştiricilere, farklı sınıflardan gelen özellikleri birleştirerek daha güçlü ve yetenekli sınıflar oluşturma esnekliği sunar. Bu, özellikle büyük ve karmaşık sistemlerde modülerlik ve ölçeklenebilirlik sağlar.
 *
 * 3. **Fonksiyonel Zenginlik:** Çoklu miras, farklı sınıflardan davranışları birleştirerek daha kapsamlı ve işlevsel sınıflar tasarlamak için olanak tanır. Bu, özellikle farklı disiplinlerden özellikleri bir araya getirmek istendiğinde yararlıdır.
 *
 * ### Çoklu Mirasın Dezavantajları
 *
 * 1. **Elmas Problemi (Diamond Problem):** Bir sınıf, iki sınıftan türediğinde ve bu sınıflar aynı temel sınıftan türediyse, alt sınıf hangi üst sınıftan hangi özellikleri miras alacağı konusunda belirsizlik yaşar. Bu, metod çağrılarında ve durum yönetiminde kafa karışıklığına yol açabilir.
 *
 * 2. **Karmaşıklık:** Çoklu miras, sınıf hiyerarşilerini karmaşıklaştırır ve kodun anlaşılmasını ve bakımını zorlaştırır. Bu karmaşıklık, büyük projelerde yönetilmesi zor hatalara neden olabilir.
 *
 * 3. **Tutarlılık Sorunları:** Farklı sınıflardan miras alınan özellikler arasında tutarlılık sağlamak zor olabilir, bu da hata yapma olasılığını artırır.
 *
 * ### Çoklu Miras Destekleyen Diller
 *
 * **C++ Örneği:**
 * C++, çoklu mirası destekler ve bu özelliği, sınıflar arası ilişkileri yönetmek için kapsamlı bir şekilde kullanır.
 *
 * ```cpp
 * class Aquatic {
 * public:
 *     void swim() { cout << "Swimming"; }
 * };
 *
 * class Bird {
 * public:
 *     void fly() { cout << "Flying"; }
 * };
 *
 * // Çoklu miras kullanarak Penguin sınıfı oluşturuluyor
 * class Penguin : public Aquatic, public Bird {
 *     // Penguin hem uçabilir hem de yüzebilir
 * };
 * ```
 *
 * **Python Örneği:**
 * Python, çoklu mirası destekler ve parantez içinde birden fazla sınıf belirterek bu özelliği kullanmanıza olanak tanır.
 *
 * ```python
 * class Aquatic:
 *     def swim(self):
 *         print("Swimming")
 *
 * class Bird:
 *     def fly(self):
 *         print("Flying")
 *
 * class Penguin(Aquatic, Bird):
 *     pass
 *
 * p = Penguin()
 * p.swim()  # Output: Swimming
 * p.fly()   # Output: Flying
 * ```
 *
 * ### Çoklu Miras Desteklemeyen Diller ve Alternatif Yaklaşımlar
 *
 * **Java Örneği:**
 * Java, çoklu mirası doğrudan desteklemez. Bunun yerine, bir sınıfın birden fazla interface'i implemente etmesine izin vererek benzer bir esneklik sunar.
 *
 * ```java
 * interface Aquatic {
 *     default void swim() {
 *         System.out.println("Swimming");
 *
 *
 *     }
 * }
 *
 * interface Bird {
 *     default void fly() {
 *         System.out.println("Flying");
 *     }
 * }
 *
 * class Penguin implements Aquatic, Bird {
 *     // Penguin sınıfı hem uçma hem de yüzme yeteneğine sahiptir
 * }
 * ```
 *
 * **Kotlin Örneği:**
 * Kotlin, çoklu sınıf mirasını desteklemez ancak çoklu interface implementasyonuna izin verir ve interface'lerdeki "default methods" özelliği ile sınıflara metod implementasyonları sağlar.
 *
 * ```kotlin
 * interface Aquatic {
 *     fun swim() {
 *         println("Swimming")
 *     }
 * }
 *
 * interface Bird {
 *     fun fly() {
 *         println("Flying")
 *     }
 * }
 *
 * class Penguin : Aquatic, Bird {
 *     // Penguin sınıfı, Aquatic ve Bird interface'lerini uygular.
 * }
 * ```
 *
 * ### Sonuç
 * Çoklu miras, bazı programlama dillerinde güçlü bir özellik olarak yer alsa da, getirdiği karmaşıklık ve
 * potansiyel sorunlar nedeniyle bazı modern diller bu özelliği farklı yollarla ele almayı tercih eder.
 * Interface'ler ve abstract sınıflar kullanarak çoklu mirasın sağladığı esneklikler benzer şekilde sağlanabilirken,
 * olası karmaşıklıklardan ve tutarlılık sorunlarından kaçınılmış olur.
 */


interface A {
    fun f() = 1
    fun g() = "A.g"
    val n: Double
        get() = 1.1
}

interface B {
    fun f() = 2
    fun g() = "B.g"
    val n: Double
        get() = 2.2
}

class C : A, B {
    override fun f() = 0
    override fun g() = super<A>.g()
    override val n: Double
        get() = super<A>.n + super<B>.n
}

//fun main() {
//    val c = C()
//    c.f()
//    c.g()
//    c.n
//}