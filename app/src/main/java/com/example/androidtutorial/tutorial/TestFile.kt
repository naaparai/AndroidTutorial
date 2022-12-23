package com.example.androidtutorial.tutorial

// higher order function and lamda
// overall android architecture
// textview, button
// github with source tree
fun main() {
    add1(1, 3)
    sub(3, 5)
    val a: Boolean = true
    val somefuntion: (String) -> String = { it.reversed() }
}

fun add1(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b
}

fun myPrint() {
    println("SomePrint")
}

fun higherOrderFunction(a: Int, b: Int, action: (Int, Int) -> Int) {
    println(a)
    println(b)
    println(action(a, b))
}
// myapp.apk
// .dex
