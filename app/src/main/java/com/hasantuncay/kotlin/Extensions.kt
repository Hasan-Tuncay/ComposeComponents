package com.hasantuncay.kotlin


    fun String.reversedWithQuoata( )=
        "\"${this.reversed()}\""
    fun String.singleQuote() = "'$this'"
    fun String.doubleQuote() = "\"$this\""



fun main(){
    println("hasan".reversedWithQuoata())

}