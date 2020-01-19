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


/**
 * 2. Singleton Classes - Objects
 * Object-oriented pattern where a class can only have one instance. (e.g. a reusable Database connection)
 * To create a singleton class use the `object` keyword
 * Singleton classes CAN'T have constructors. It can contain properties and methods
 * THey ca inherit from classes and implement interfaces.
 */
object SingletonExample {
    var isAlive = true
    fun die() {
        println("You won't live anymore!!!")
        this.isAlive = false
    }
    fun live() {
        println("Let's make you live again!!")
        this.isAlive = true
    }
}

/**
 * 2.1. Objects expressions
 * Can be used to create objects of an anonymous class -- anonymous objects.
 * Used if you need to do a small modification of an existing class or interface without creating a subclass.
 */
open class Human(var name: String, var age: Int = 1) {
    init {
        println("New human: $name, $age")
    }
    fun eat() = println("We like to eat.")
    fun talk() = println("We talk to each other in a language.")
    open fun pray() = println("We pray a lot for many reasons.")
}


/**
 * 3. Kotlin Companion objects
 * Make a member class (property or function) as a static member
 * So no need to create an instance to call the member class.
 * To make companion object -- object declaration required.
 * Only one companion object per class is allowed.
 * Strong use cas for companion objects: Factory Method patterns.
 */
class Laptop(val model: String, val cpu: String) {
    private val price: Int = 999
    init {
        println("New laptop: $model, $cpu")
    }
    fun showDescription() = println("Laptop description: $model and $cpu processor")

    // The getLaptopOs function behaves like a static function
    companion object LaptopOS {
        fun getLaptopOs(os: String) = println("This laptop is running on $os.")
    }

}
fun main(args: Array<String>) {
    /**
     * 1. Using sealed classes example.
     */
    println(eval(Single("joel")))
    println(eval(Married("dannel", "katrina")))
    println(eval(Divorced("rene", "aracelys")))
    println(eval(NotValidStatus))
    println()

    /**
     * 2. Using Singleton examples.
     * All state changes are getting store to the same class. Global stated.
     * Not recommended to use in large software programs.
     */
    println("Are you alive? ${SingletonExample.isAlive}")
    SingletonExample.die()
    println("Are you alive? ${SingletonExample.isAlive}")
    SingletonExample.live()
    println("Are you alive? ${SingletonExample.isAlive}")
    println()

    /**
     * 2. Using object expressions to modify the behavior of a class or interface.
     */
    var person: Human = Human("joel")
    person.eat()
    person.pray()

    // No need to create a subclass called Atheist to override behavior of pray function.
    /**
     * You are instantiating the object while overriding some of its properties and functions.
     */
    var atheist: Human = object : Human("eitan", 18) {
        override fun pray() = println("I am not a believer and I don't pray at all.")
    }

    var orthodox: Human = object : Human("matanel", 23) {
        override fun pray() = println("I pray every single day")
    }
    atheist.eat()
    atheist.pray()
    orthodox.pray()
    println()

    /**
     * 3. Using companion objects
     */
    Laptop.getLaptopOs("windows")
    Laptop.getLaptopOs("ubuntu")
    var l = Laptop("Dell XP 13", "i3 Dual core")
    l.showDescription()
}