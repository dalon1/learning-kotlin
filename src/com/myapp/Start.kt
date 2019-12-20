package com.myapp

import java.util.Scanner

/**
 * This is my first program written in Kotlin
 */

fun main(args : Array<String>) {
    // 1. data types
    var name : String = "Dannel"
    val lname : String
    lname = "alon"
    println("$name $lname")

    // 2. operators
    val a : Byte = 8
    val b : Byte = 2
    var result : Double
    result = (a + b).toDouble()
    println("$a + $b = $result")
    result = (a - b).toDouble()
    println("$a - $b = $result")
    result = (a * b).toDouble()
    println("$a * $b = $result")
    result = (a / b).toDouble()
    println("$a / $b = $result")
    result = (a % b).toDouble()
    println("$a % $b = $result")
    var c : Int = 2
    c *= 10
    println(c)

    // 3. Logical operators
    val max = if (a > b) { a } else { b }
    println("Max: $max")

    var d : String = if (true && true) {
        print("\nSomeone has been found!\n")
        "Dannel"
    } else { "Nobody" }

    var e : String = if (false || false) {
        print("Hola")
        "Dannel"
    } else {"nothing"}
    println("d value: $d")
    println("e value: $e")

    // 3. in or !in logical operators
    var brothers : Array<String> = arrayOf("dannel", "joel", "eitan")
    var isFound : String = if ("carlos" in brothers) {"FOUND" } else { "NOT FOUND"}
    println("Brother carlos is $isFound")

    var g : Int = 1
    var h : Float = g.toFloat() // Forced to use casting methods.

    // 4. "if" in Java is a condition, while Kotlin "if" is an expression

    //5. Kotlin input statement
    print("user-id: ")
    var p : String = readLine()!!
    println("welcome $p")

    val reader = Scanner(System.`in`)
    print("Enter your age: ")
    var age : Int = reader.nextInt()
    println("your age is $age")
}