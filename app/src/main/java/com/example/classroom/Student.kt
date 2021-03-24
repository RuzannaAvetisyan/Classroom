package com.example.classroom

data class Student(
    val name: String,
    val surname: String,
    val age: Int,
    val grades: MutableList<Grade> = mutableListOf()
)


val students = mutableListOf(
    Student("Armen", "Smith", 23),
    Student("Serj", "Smith", 21),
    Student("Robert", "Smith", 20),
    Student("Nikol", "Smith", 18),
    Student("Levon", "Smith", 36)
)