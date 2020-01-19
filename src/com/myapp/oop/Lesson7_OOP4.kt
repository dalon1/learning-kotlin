package com.myapp.oop

import com.sun.org.apache.xerces.internal.impl.dv.dtd.NOTATIONDatatypeValidator
import java.lang.Exception

/**
 * 1. Sealed Classes? use for "restricted class hierarchies". Extension of an ENUM class.
 * Value can only have one of the types from a limited set.
 * Use keyword `sealed` to make a class as a sealed class.
 * Sealed classes restrict the possibility of created subclasses.
 * Notice how the when expression doesn't throw exception when new subclasses have been added.
 */
/*open class Someone
class Single(val name: String): Someone()
class Married(val name1: String, val name2: String) : Someone()

fun eval(e: Someone): String = when(e) {
    is Single -> "${e.name} is single!"
    is Married -> "${e.name1} and ${e.name2} are married and in love!"
    else ->
        throw Exception("This can't be possible.")
}*/

/**
 * 1.1 Using sealed classes.
 * Here, the when expression will throw an exception if one of the subclasses is not handled
 */
sealed class Someone
class Single(val name: String): Someone()
class Married(val name1: String, val name2: String) : Someone()
class Divorced(val name1: String, val name2: String) : Someone()
object NotValidStatus: Someone()

fun eval(e: Someone): String = when(e) {
    is Single -> "${e.name} is single!"
    is Married -> "${e.name1} and ${e.name2} are married and in love!"
    is Divorced -> "${e.name1} and ${e.name2} are divorced and hate each other!"
    is NotValidStatus -> "I don't know what to do"
}

/**
 * 1.2. Important notes:!!!!!
 * All subclasses of a sealed class must be declared in the same file.
 * A sealed class is abstract and can't be instantiated.
 * Sealed class constructors are private by default.
 * Sealed vs Enum: really similar
 * Difference: enum can have just one instance. Sealed class can have multiple instances.
 */

fun main(args: Array<String>) {
    /**
     * 1. Using sealed classes example.
     */
    println(eval(Single("joel")))
    println(eval(Married("dannel", "katrina")))
    println(eval(Divorced("rene", "aracelys")))
    println(eval(NotValidStatus))

    
}