package com.hasantuncay.kotlin.usability.destructuringdeclarations

class Employee(val id: Int, val name: String, val department: String, val salary: Double) {
    /**
     *componentN() fonksiyonlarının basit bir tanımı:
     *
     * componentN() fonksiyonları, bir nesnenin belirli özelliklerine erişmek için tanımlanan özel fonksiyonlardır.
     * Bu fonksiyonlar, destructuring işlemleri için kullanılır ve nesnelerin parçalara ayrılmasını sağlar.
     * Sınıflarınızda componentN() fonksiyonlarını tanımlayarak, destructuring işlemlerini özelleştirebilir ve
     * sınıflarınızı destructuring işlemleri için hazır hale getirebilirsiniz.
     */
    operator fun component1(): Int = id
    operator fun component2(): String = name
    operator fun component3(): String = department
    operator fun component4(): Double = salary
}
fun main() {


    val employee = Employee(101, "John Doe", "Engineering", 75000.0)

    // Destructuring declaration
    val (id, name, department, salary) = employee
  //  val (id, name, _,department) = employee
    println("Employee ID: $id")
    println("Employee Name: $name")
    println("Employee Department: $department")
    println("Employee Salary: $salary")
}
