package com.hasantuncay.designPatterns.creational.builderpattern;

public class Main {
    public static void main(String[] args) {
        Pizza pizza = new Pizza.Builder() // Builder nesnesi oluşturuluyor
                .dough("thin") // hamur tipi belirleniyor
                .sauce("tomato") // sos belirleniyor
                .addTopping("cheese") // peynir ekleniyor
                .addTopping("pepperoni") // pepperoni ekleniyor
                .build(); // Pizza nesnesi oluşturuluyor
        System.out.println(pizza);
    }
}
/**
 *Executing tasks: [:app:Main.main()] in project /Users/hasantuncay/Android Codelabs/practise/app
 *
 *
 * FAILURE: Build failed with an exception.
 *
 * * Where:
 * Initialization script '/private/var/folders/ff/m_1sxjc93ld9kdrw61xm25rw0000gn/T/Main_main__1.gradle' line: 41
 *
 * * What went wrong:
 * A problem occurred configuring project ':app'.
 * > Could not create task ':app:Main.main()'.
 *    > SourceSet with name 'main' not found.
 *
 * * Try:
 * > Run with --stacktrace option to get the stack trace.
 * > Run with --info or --debug option to get more log output.
 * > Run with --scan to get full insights.
 *
 * * Get more help at https://help.gradle.org
 *
 * Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0.
 *
 * You can use '--warning-mode all' to show the individual deprecation warnings and determine if they come from your own scripts or plugins.
 *
 * See https://docs.gradle.org/8.0/userguide/command_line_interface.html#sec:command_line_warnings
 *
 * BUILD FAILED in 202ms
 *  sorun ne
 * ChatGPT
 * Hatanız, Gradle projesinde bir SourceSet bulunamadığına işaret ediyor, özellikle main isimli bir SourceSet.
 * Bu durum, genellikle Java veya Kotlin projesindeki yapılandırmanın yanlış olması veya
 * beklenen yapılandırmanın eksik olması durumlarında ortaya çıkar. Siz Java/Kotlin kodunu doğrudan Android Studio veya
 * IntelliJ IDEA gibi bir IDE üzerinden çalıştırmaya çalışıyorsunuz, ancak yapılandırma Android uygulaması için yapılandırılmış ve
 * bir Java/Kotlin konsol uygulamasını çalıştırmak için gerekli ayarlar eksik.
 *
 * Sorunun Çözümü için Adımlar
 * 1. build.gradle Dosyanızı Kontrol Edin
 * Eğer bir Android projesi üzerinde çalışıyorsanız ve belirli bir main fonksiyonunu çalıştırmak istiyorsanız,
 * Android projesinin yapılandırmasında doğrudan SourceSet tanımlamanız gerekmez. Bunun yerine,
 * Android Studio'nun sağladığı Run yapılandırmalarını kullanarak bir Activity başlatırsınız.
 * Java veya Kotlin konsol uygulaması çalıştırmak istiyorsanız, uygun yapılandırma farklı olacaktır.
 *
 * 2. Konsol Uygulaması için Proje Yapılandırması
 * Eğer gerçekten bir Java/Kotlin konsol uygulaması çalıştırmaya çalışıyorsanız ve Android uygulaması değil,
 * muhtemelen proje yapılandırmanızda bir hata yapmışsınızdır. Bu durumda,
 * bir Java veya Kotlin projesi oluştururken IDE'nin sağladığı yapılandırma şablonlarını kullanmanız gerekir.
 *
 * 3. Android Studio İçinde Java/Kotlin Konsol Uygulaması Çalıştırma
 * Android Studio, Android uygulamaları geliştirmek için tasarlanmıştır ve
 * doğrudan Java/Kotlin konsol uygulamalarını çalıştırmak için optimize edilmemiştir.
 * Bununla birlikte, Android Studio içinde saf Java/Kotlin modülleri oluşturabilir ve
 * bu modüller üzerinde konsol uygulamalarını çalıştırabilirsiniz.
 * Bunu yapmak için yeni bir modül eklemeniz ve bu modül için uygun yapılandırmayı seçmeniz gerekir.
 *
 * 4. Gradle Yapılandırmasını Gözden Geçirin
 * Projenizde doğrudan Java veya Kotlin main fonksiyonunu çalıştırmaya yönelik bir yapılandırma yapmak istiyorsanız,
 * Gradle yapılandırmanızda application plugin'ini ve uygun mainClassName tanımlamasını yapmanız gerekir:
 *
 * gradle
 * Copy code
 * apply plugin: 'application'
 *
 * mainClassName = 'com.yourpackage.MainKt'
 * Yukarıdaki yapılandırma, MainKt sınıfınızın tam yolu ile değiştirilmelidir.
 *
 * 5. IDE ve Gradle Sürüm Uyumsuzlukları
 * Eğer "Deprecated Gradle features were used in this build, making it incompatible with Gradle 9.0."
 * gibi bir uyarı alıyorsanız, projenizin kullandığı Gradle sürümü ile kullanılan plugin'ler veya yazılım özellikleri
 * arasında bir uyumsuzluk olabilir. Bu durumda, Gradle sürümünüzü projenize uygun bir sürüme güncellemeniz veya kullanılan
 * plugin'leri güncellemeniz gerekebilir.
 *
 * Sorununuzu çözmek için, öncelikle projenizin tam olarak ne yapmaya çalıştığını ve
 * hangi türde bir uygulama geliştirdiğinizi (Android uygulaması mı yoksa saf Java/Kotlin konsol uygulaması mı)
 * netleştirmeniz önemlidir. Bu bilgilere göre uygun yapılandırmayı seçmelisiniz.
 *
 *
 *
 * */