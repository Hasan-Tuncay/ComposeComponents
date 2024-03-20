package com.hasantuncay.designPatterns.creational.builderpattern

 fun main(){
     val pizza = Pizza.Builder() // Builder nesnesi oluşturuluyor
         .dough("thin") // hamur tipi belirleniyor
         .sauce("tomato") // sos belirleniyor
         .addTopping("cheese") // peynir ekleniyor
         .addTopping("pepperoni") // pepperoni ekleniyor
         .build() // Pizza nesnesi oluşturuluyor

     println(pizza)
 }