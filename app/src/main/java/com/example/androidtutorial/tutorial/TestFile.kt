package com.example.androidtutorial.tutorial

// higher order function and lamda
// overall android architecture
// textview, button
// github with source tree
fun main() {
    add1(1, 3)
    sub(3, 5)
    val a: Boolean = true
    solution("BANANA")
    solution("NAABXXAN")
    solution("NAANAAXANABABYNNBZ")
}

fun add1(a: Int, b: Int): Int {
    return a + b
}

fun sub(a: Int, b: Int): Int {
    return a - b
}

fun solution(text: String): Int {
    val bCount: Int = text.length - text.replace("B", "").length
    var nCount: Int = text.length - text.replace("N", "").length
    var aCount: Int = text.length - text.replace("A", "").length
    var count = 0
    for (i in 0 until bCount) {
        nCount -= 2
        aCount -= 3
        if (nCount >= 0 && aCount >= 0) {
            count = count + 1
        } else {
            break
        }
    }
    return count
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
