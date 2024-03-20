package com.hasantuncay.composeComponents.string

class Accessible {

    var mutable: String = ""
        get() {
            println("mutable:get")
            return mutable
        }
        set(value) {
            println("mutable:set")
            field = value
        }

    val readOnly: String = ""
        get() {
            println("readOnly:get")
            return field
        }
}
fun main() {
    /*
      val accessible = Accessible()
      accessible.mutable = "abc"
      accessible.readOnly eq "abc"
    */
}
/* Expected output:
mutable:set
readOnly:get
mutable:get
abc
 */