package com.hasantuncay.designPatterns.structural

/***
 * ### Adapter Pattern: Akademik Açıklama ve Android Uygulama Örnekleri
 *
 * #### Adapter Pattern (Adaptör Deseni) Nedir?
 * Adapter Pattern, iki farklı arayüzü uyumlu hale getirerek birlikte çalışmalarını sağlayan yapısal bir tasarım desenidir.
 * Bu desen, var olan bir nesnenin dış bir API ya da başka bir modül ile uyumlu hale gelmesini sağlamak için ara bir katman olarak işlev görür.
 * Temel amaç, mevcut sistemi değiştirmeden veya yeni sistemlerin karmaşıklığını artırmadan entegrasyon sağlamaktır.
 *
 * #### Neden Kullanılır?
 * 1. **Uyumluluk Sorunlarını Çözme**: Farklı sistemler veya kütüphaneler arasındaki uyumluluk sorunlarını çözer.
 * 2. **Mevcut Kodun Korunması**: Mevcut sistem üzerinde herhangi bir değişiklik yapmadan yeni özelliklerin veya
 * arayüzlerin entegre edilmesine olanak tanır.
 * 3. **Sürdürülebilirlik ve Genişletilebilirlik**: Kodun yeniden kullanılabilirliğini artırır ve sistemler arası bağımsızlığı güçlendirir.
 *
 * #### Uygulama Örnekleri: Android Compose ile Adapter Pattern
 * Android geliştirmede Adapter Pattern, genellikle veri setlerini UI komponentleriyle bağlamak için kullanılır. Compose'da geleneksel
 * `RecyclerView`'ın yerine `LazyColumn` veya `LazyRow` gibi komponentler kullanılır, ancak bazen veri kaynaklarını bu yeni
 * UI elementlerine uygun hale getirmek için adapter benzeri yapılar kullanmak gerekebilir.
 *
 * ##### Örnek 1: Compose ile Basit List Adapter
 * ```kotlin
 * // Compose UI ile basit bir liste gösterimi için adapter benzeri yapı
 * @Composable
 * fun SimpleList(data: List<String>) {
 *     LazyColumn {
 *         items(data) { item ->
 *             Text(text = item, modifier = Modifier.padding(8.dp))
 *         }
 *     }
 * }
 *
 * @Preview(showBackground = true)
 * @Composable
 * fun PreviewSimpleList() {
 *     SimpleList(data = listOf("Item 1", "Item 2", "Item 3"))
 * }
 * ```
 * **Kod Açıklaması:**
 * - `SimpleList`: Verilen string listesini alır ve `LazyColumn` kullanarak ekranda listeler.
 * - `items`: `LazyColumn` için bir adaptasyon işlevi görür, her bir elemanı ekranda bir `Text` komponenti olarak render eder.
 *
 * ##### Örnek 2: Compose ile Tip Adaptasyonu
 * Farklı türdeki verileri aynı listeye render etmek için genel bir adapter yapısı kullanılabilir.
 *
 * ```kotlin
 * sealed class ListItem {
 *     data class Header(val title: String) : ListItem()
 *     data class Content(val text: String) : ListItem()
 * }
 *
 * // Compose UI içinde farklı tipleri render etmek için adapter benzeri yapı
 * @Composable
 * fun ComplexList(data: List<ListItem>) {
 *     LazyColumn {
 *         items(data) { item ->
 *             when (item) {
 *                 is ListItem.Header -> Text(text = item.title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(8.dp))
 *                 is ListItem.Content -> Text(text = item.text, modifier = Modifier.padding(8.dp))
 *             }
 *         }
 *     }
 * }
 *
 * @Preview(showBackground = true)
 * @Composable
 * fun PreviewComplexList() {
 *     ComplexList(data = listOf(ListItem.Header("Header"), ListItem.Content("Item 1"), ListItem.Content("Item 2")))
 * }
 * ```
 * **Kod Açıklaması:**
 * - `ListItem`: Farklı tiplerde verileri temsil eden sealed class yapısı.
 * - `ComplexList`: `LazyColumn` içinde farklı tipleri uygun şekilde render eder. `when` ifadesi ile tip kontrolü yapılarak
 * `Header` veya `Content` olarak uygun UI komponenti seçilir ve render edilir.
 *
 * Her iki örnekte de, Kotlin Compose ile `LazyColumn` ve `items` fonksiyonları, geleneksel adapter deseninin işlevlerini üstlenir ve
 * UI komponentlerine verileri adaptasyonu sağlar. Bu, Android Compose'un deklaratif yap
 *
 * ısı sayesinde, esnek ve okunabilir kodlar yazılmasına olanak tanır.
 */

// Medya oynatma işlevselliğini tanımlayan arayüz
interface MediaPlayer {
    fun play(fileType: String, fileName: String)
}

// Varsayılan olarak sadece MP3 dosyalarını oynatabilen bir oynatıcı
class AudioPlayer : MediaPlayer {
    override fun play(fileType: String, fileName: String) {
        if (fileType.equals("mp3", ignoreCase = true)) {
            println("Oynatılıyor (MP3): $fileName")
        } else {
            println("Desteklenmeyen format: $fileType")
        }
    }
}

// İleri medya türlerini destekleyen adaptör
class MediaAdapter(private val fileType: String) : MediaPlayer {
    private val advancedMediaPlayer: AdvancedMediaPlayer = when (fileType.toLowerCase()) {
        "vlc" -> VlcPlayer()
        "mp4" -> Mp4Player()
        else -> throw IllegalArgumentException("Geçersiz medya formatı")
    }

    override fun play(fileType: String, fileName: String) {
        advancedMediaPlayer.play(fileName)
    }
}

// Gelişmiş medya oynatıcı arayüzü
interface AdvancedMediaPlayer {
    fun play(fileName: String)
}

// VLC dosyalarını oynatma yeteneği
class VlcPlayer : AdvancedMediaPlayer {
    override fun play(fileName: String) {
        println("Oynatılıyor (VLC): $fileName")
    }
}

// MP4 dosyalarını oynatma yeteneği
class Mp4Player : AdvancedMediaPlayer {
    override fun play(fileName: String) {
        println("Oynatılıyor (MP4): $fileName")
    }
}

// Ana sınıf
fun main() {
    val player = AudioPlayer()
    player.play("mp3", "beyond_the_horizon.mp3")
    val mp4Player = MediaAdapter("mp4")
    mp4Player.play("mp4", "alone.mp4")
    val vlcPlayer = MediaAdapter("vlc")
    vlcPlayer.play("vlc", "far_far_away.vlc")
}
// Hedef arayüz
interface EuropeanPlugConnector {
    fun provideElectricity()
}

// Adaptörle uyumlu olan Amerikan priz
class AmericanPlug {
    fun provide110Volt() {
        println("110 Volt elektrik sağlanıyor.")
    }
}

// Amerikan prizi için bir adaptör
class AmericanToEuropeanAdapter(private val americanPlug: AmericanPlug) : EuropeanPlugConnector {
    override fun provideElectricity() {
        americanPlug.provide110Volt()
        println("Adaptör kullanılarak Avrupa standardında elektrik sağlanıyor.")
    }
}

//fun main() {
//    val europeanPlug: EuropeanPlugConnector = AmericanToEuropeanAdapter(AmericanPlug())
//    europeanPlug.provideElectricity()
//}
