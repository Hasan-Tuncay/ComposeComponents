package com.hasantuncay.kotlin.destructuringdeclarations

data class Student(
    val name: String,
    val age: Int,
    val grade: String,
    val favoriteSubject: String,
    val extracurricularActivity: String
)
// Returns a Pair of student's name and grade
fun getBasicInfo(student: Student): Pair<String, String> = Pair(student.name, student.grade)

// Returns a Triple of student's name, age, and favorite subject
fun getDetailedInfo(student: Student): Triple<String, Int, String> = Triple(student.name, student.age, student.favoriteSubject)



fun main() {
    val student = Student("Ayşe", 10, "5A", "Science", "Chess Club")

    // Destructuring using componentN functions
    val (name, age, grade, favoriteSubject, extracurricularActivity) = student

    println("Student's Name: $name")
    println("Student's Age: $age")
    println("Student's Grade: $grade")
    println("Favorite Subject: $favoriteSubject")
    println("Extracurricular Activity: $extracurricularActivity")


    // Destructuring a Pair
    val (studentName, studentGrade) = getBasicInfo(student)
    println("$studentName is in grade $studentGrade.")

    // Destructuring a Triple
    val (name1, age1, favoriteSubject1) = getDetailedInfo(student)
    println("$name1, age $age1, loves $favoriteSubject1.")

    val students = listOf(
        Student("Ayşe", 10, "5A", "Science", "Chess Club"),
        Student("John", 11, "6B", "Math", "Robotics Club")
    )
/**
 * (name, _, grade, _, _)
 * Bu yapıya "destructuring declaration" (yapısal ayrıştırma bildirimi) denir. Kotlin'de,
 * bu özellik sayesinde bir nesnenin birden fazla özelliği veya bir koleksiyondaki öğeler,
 * tek bir ifadeyle birden fazla değişkene aynı anda atanabilir. Destructuring declaration, özellikle listeler veya
 * diziler gibi koleksiyonlar üzerinde döngü yaparken veya birden fazla değer döndüren fonksiyonların sonuçlarını işlerken kullanışlıdır.
 *
 * */

val (_, _, name2,_,_)=student
    for ((name2, _, grade, _, _) in students) {
        println("$name is in grade $grade.")
    }

}
