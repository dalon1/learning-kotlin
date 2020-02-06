package com.myapp.oop

/**
 * 1. Kotlin Extension functions?
 * It extends a class with new functionality without creating a subclass.
 * The new function is defined outside the class it is extending.
 *
 * extension function? = a member function of class that is defined outside the class.
 * Extensions functions should not be overused.
 */
// Let's add functionality to the String class.
fun String.removeAllWhiteSpaces() : String = this.replace(" ", "")

open class Developer(var name: String, var programmingLanguages: Array<String> ) {
    init {
        println("Hello World, $name has joined the developer community.")
    }

    fun listAllLanguages() = programmingLanguages.forEach { language -> println("I know to program in ${language}") }
}
// Here I have extended the developer class with a new function that has access to all properties members of the Developer class.
fun Developer.showIndustry(industry: String) = println("I, $name, work in the $industry industry.")


/**
 * 2. Operator overloading.
 * Allows you define the behavior of certain operators for your user defined classes. (e.g. lets add two points, or books, etc)
 * plus() operator = addition
 * dec() operator = substraction by 1 (--)
 */

class Point(var x: Int, var y: Int) {
    operator fun plus(other: Point) : Point {
        return Point(this.x + other.x, this.y + other.y)
    }

    operator fun minus(other: Point) = Point(x - other.x, y - other.y)

    operator fun dec() : Point = Point(--x, --y)

    override fun toString(): String = "($x, $y)"
}

/**
 * 2.1. To know more about all the operators available, please go to: https://kotlinlang.org/docs/reference/operator-overloading.html
 */
fun main(args: Array<String>) {
    /**
     * 1. Using extension functions.
     * Adding functionality to the string class
     */
    var myName = "dannel alon gonzalez"
    println(myName.removeAllWhiteSpaces())
    println()

    var dannel: Developer = Developer("Dannel Alon", arrayOf("groovy", "java", "kotlin"))
    dannel.listAllLanguages()
    dannel.showIndustry("banking")
    println()

    /**
     * 2. Using operator overloading.
     */
    var p1 = Point(10, 20)
    var p2 = Point(-2, 15)
    println("p3: ${(p1 + p2)}")
    println("p4: ${p1 - p2}")
    println("p1: ${(--p1)}")
}