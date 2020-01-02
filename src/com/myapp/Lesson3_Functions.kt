package com.myapp

class Person {
    infix fun sayHi(language : String) {
        var hi = when(language) {
           "hebrew" -> "Shalom!"
           "spanish" -> "Hola!"
           "english" -> "Hello!"
           else -> "I don't know what you speak"
       }
        println("Person says: $hi")
    }
}
fun main(args : Array<String>) {
    /***
     * *************************************************************
     * FUNCTIONS
     * Type of functions:
     * 1. Kotlin Standard Library Function
     * 2. User-defined functions
     * *************************************************************
     */

    /**
     * Kotlin standard library functions
     * 1. built-in functions within Kotlin ready to be used. e.g. println()
     */
    callMe()
    mySum(10, 10)
    println(getName("dannel", "alon"))
    println(getName("joel", "alon"))

    /**
     * 2. Infix function call
     * Infix requirements:
     * a. member function
     * b. one single parameter only
     * c. marked with infix keyword
     */
    val p = Person()
    p sayHi "hebrew"

    /**
     * 3. Default values and named arguments
     * Kotlin accepts defaults values for parameters
     */
    println(getDiscount(100.toDouble(), 25.toDouble()))
    println(getDiscount(100.0))
    println(getDiscount(discount = 50.0, price = 600.0))

    /**
     * 3. Recursive functions
     * recursive function is a function that calls itself -- recursion
     */
    println("Factorial of 6: ${factorial(6)}")

    /**
     * 4. Tail recursions - functions
     * a recursive function can be tail recursion if the last operation is the function calling itself
     */
    //println(recursiveN(10))
    println(factorial(6, 1))
}

fun callMe() {
    println("My first user defined function!")
}
fun mySum(n1: Int, n2: Int) : Int {
    println("My calculator says $n1 + $n2 = ${n1+n2}")
    return n1 + n2
}

fun getName(fname : String, lname : String) : String = "$fname $lname"

fun getDiscount(price:Double, discount:Double = 0.0) : Double = price - ((price * discount) / 100)

fun factorial(n: Int) : Int = if (n == 1) n else n*factorial(n - 1)

tailrec fun factorial(n : Int, run : Int = 1) : Int = if (n == 1) run else factorial(n-1, run * n)

tailrec fun recursiveN(n : Int) : Int = if (n == 1) n else recursiveN(n - 1)