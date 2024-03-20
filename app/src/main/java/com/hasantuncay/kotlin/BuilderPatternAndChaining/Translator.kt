package com.hasantuncay.kotlin.BuilderPatternAndChaining

class Translator {
    private var sourceText: String = ""
    private var sourceLang: String = "EN"
    private var targetLang: String = "TR"
    private var useFormalLanguage: Boolean = false

    fun sourceText(text: String): Translator {
        this.sourceText = text
        return this
    }

    fun sourceLang(lang: String): Translator {
        this.sourceLang = lang
        return this
    }

    fun targetLang(lang: String): Translator {
        this.targetLang = lang
        return this
    }

    fun useFormal(useFormal: Boolean): Translator {
        this.useFormalLanguage = useFormal
        return this
    }

    fun translate(): String {
        // Burada gerçek bir çeviri işlemi simüle ediyoruz.
        // Gerçek bir uygulamada, bu kısım bir API çağrısı ile gerçekleştirilir.
        return "[$sourceLang->$targetLang] Çevrilen metin: \"$sourceText\" (Formal: $useFormalLanguage)"
    }
}

fun main() {
    val translator = Translator()
    val translatedText = translator
        .sourceText("Hello, how are you?")
        .sourceLang("EN")
        .targetLang("TR")
        .useFormal(true)
        .translate()

    println(translatedText)
    // Örnek çıktı: [EN->TR] Çevrilen metin: "Hello, how are you?" (Formal: true)
}
