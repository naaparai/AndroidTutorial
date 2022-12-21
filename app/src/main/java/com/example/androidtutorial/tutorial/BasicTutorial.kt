package com.example.androidtutorial.tutorial

class BasicTutorial {
    var a :Int ?  = 0
    var b :Boolean = true
    var l = 0L
    var c = 'c'
    var s : String ? = "some string"
    val pi = 3.14

}

fun main(){
    var object1 = BasicTutorial()
    object1.a = null
    object1.b  = false
    object1.s = null
    printSomething(object1.s ?: "default")
    printSomething("${object1.a ?: 0}")
    val list = listOf("one","two","three")
    val mutableList = mutableListOf("one","two","three")
    mutableList.add("four")
    mutableList.add("five")
    mutableList.add("six")

    // for(i = 0, i < mutableList.size, i ++)
    mutableList.forEach {  number ->
        printSomething(number)
    }

    val set = setOf("three","two","one")
    val mutableSetOf = mutableSetOf<String>()
    val hash = hashMapOf<String,String>()
    val map = mapOf(Pair(1,"One"), Pair(2,"Two"))
    val mutableMapOf = mutableMapOf(Pair(1,"One"), Pair(2,"Two"))
    mutableMapOf[3] = "three"
    printSomething(mutableMapOf[10] ?: "default")
}

fun printSomething(text: String){
    println(text)
}

fun add(a: Int, b: Int) : Int{
    return a + b
}