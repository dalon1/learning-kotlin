package com.myapp.oop

import javax.print.attribute.standard.JobOriginatingUserName

/**
 * 1. Interfaces - in Java 8.
 * Contain definitions of abstract methods + non-abstract methods. No state allowed.
 * Properties inside interfaces need to be abstract - or provide accessor implementations.
 * keyword `interface` is used to define interfaces
 */

interface ISomething {
    var something: String   // abstract property
    // You can't do val random: String = "Random message" >> Not valid inside an interface.
    val random: String // setting constant values
    get() = "Random message"

    fun doNothing() = println("Doing nothing at all!") // function with default behaviour
    fun doSomething() // abstract function
}

class SomethingImpl: ISomething {
    override var something: String = ""
    override fun doSomething() {
        println("I'll do something later.")
    }
}

/**
 * 2. Using multiple interfaces in a class.
 * Note: Kotlin DOES NOT allow multiple inheritance.
 */
interface IPay {
    fun pay(method:String = "cash") = println("I pay using $method")
    fun askMoney()
}
interface IShop {
    fun shop(method:String = "online") = println("I like to do shopping $method")
}

class Girl(var name: String): IPay, IShop {
    init {
        println("I am a barbie girl, in a barbie world...")
    }

    override fun askMoney() {
        println("Can you please give me more money?")
    }
}

/**
 * 3. Conflicts in override.
 * You need to provide your own behavior if two methods with same name are defined in different interfaces.
 */
interface IA {
    fun callMe() = println("I'm coming from interface A")
}
interface IB {
    fun callMe() = println("I'm coming from interface B")
}
class Telephone: IA, IB {
    override fun callMe() {
        super<IA>.callMe()
        super<IB>.callMe()
    }
}

/**
 * 4. Using nested classes.
 * Nested class = a class defined inside another class.
 * The nested class and its members can be accessed using the dot notation
 * E.g. OuterClass.NestedClass.do()
 * Kotlin nested class similar to static nested class in Java
 * By default, the nested class CAN'T access the members of the outer class.
 */
class OutClass {
    var something: String = "AHAHAHA"
    init {
        println("This message is coming from OutClass")
    }

    class NestedClass {
        init {
            println("This message is coming from NestedClass")
        }
        val msg = "A message to the world."
        fun doSomething() = println("Living the life inside my nested class.")
    }
}

/**
 * 4.1. Making Outer class visible to the nested class.
 * The keyword `inner` is required to allow the nested class to access the outer class' members.
 */
class OutClass1(var msg: String = "Hello World<Outer Class>.") {
    inner class NestedClass1 {
        // without the keyword `inner` the below function will throw exception.
        fun sayHi() = println("The nested class now has access to the property msg = $msg")
    }
}

/**
 * 5. Using Data Classes.
 * Data Class? = A class only used to hold data.
 * The keyword `data` is used to create a data class.
 * The data class comes with functions: `copy()`, `equals()`, `hashCode()`, `toString()` form of primary constructor.
 * `componentN()` function
 */

/**
 * 5.1. Requirements of a Data class.
 * 1. Primary constructor with 1 parameter - at least.
 * 2. Parameters marked with `var` or `val` keywords
 * 3. Class can't be open, abstract, inner or sealed.
 * 4. Class can extend other classes or implement interfaces.
 */
// Compiler automatically generates functions `copy()`, `equals()`, `hashCode()`, `toString()`
data class User(var userName: String, var passwd: String)

/**
 * 5.2. Data Class: Using function `copy()`
 * Create a copy of an object with some different or same properties
 */

/**
 * 5.3 Data Class: Using function `toString()`
 * Returns a string representation of the object
 */

/**
 * 5.4. Data Class: Using function `hashCode()`
 * Returns hash code of an object. If two objects are equal, hashCode returns the same number.
 * Hash Code?: It's a number that allows objects to be stored and retrieved quickly in a hash table.
 */

/**
 * 5.5. Data Class: Using function `equals()`
 * Returns true (boolean) if two objects are equal -- has the same hashCode()
 */

/**
 * 6. Data Class: Destructuring declarations
 * You could breakdown a data class into a number of variables using destructing declaration.
 */

data class Car(val brand:String, val model:String, val year:Int)

fun main(args: Array<String>) {

    /**
     * 1. Using interfaces. Instantiating a class that implements an interface.
     */
    val something: SomethingImpl = SomethingImpl()
    something.doNothing()
    something.doSomething()
    println("Random: ${something.random}")
    println()

    /**
     * 2. Implementing multiple interfaces.
     */
    var genesis = Girl("genesis")
    genesis.askMoney()
    genesis.shop("in store")
    genesis.pay("credit card")
    println()

    /**
     * 3. Fixing override conflict from multiple interfaces.
     */
    var telephone:Telephone = Telephone()
    telephone.callMe()
    println()

    /**
     * 4. Using nested classes
     */
    var me = OutClass.NestedClass()
    println(me.msg)
    me.doSomething()
    println()

    /**
     * 4.1. Making outer class visible to nested class
     */
    var me1 = OutClass1("Dannel is here!").NestedClass1()
    me1.sayHi()
    println()

    /**
     * 5.1. Creating a data class.
     */
    var myUser = User("dalon", "password")
    println("Data Class - User: -u ${myUser.userName} -p ${myUser.passwd}")

    /**
     * 5.2. Data Class: Using function `copy()`
     * Create a copy of an object with some different or same properties
     */
    var user2 = myUser.copy(userName = "jalon99")
    println("Data Class - User: -u ${user2.userName} -p ${user2.passwd}")
    println()

    /**
     * 5.3 Data Class: Using function `toString()`
     * Returns a string representation of the object
     */
    println("My user: ${myUser.toString()} && ${user2.toString()}")
    println()

    /**
     * 5.4. Data Class: Using function `hashCode()`
     * Returns hash code of an object. If two objects are equal, hashCode returns the same number.
     * Hash Code?: It's a number that allows objects to be stored and retrieved quickly in a hash table.
     */
    println("Compare hash code: ${myUser.userName}:${myUser.hashCode()} != ${user2.userName}:${user2.hashCode()}")
    println("Compare hash code: ${myUser.userName}:${myUser.hashCode()} = ${myUser.userName}:${myUser.hashCode()}")
    println()

    /**
     * 5.5. Data Class: Using function `equals()`
     * Returns true (boolean) if two objects are equal -- has the same hashCode()
     */
    var user3 = user2.copy() // not equal user2.copy(userName = "Obama")
    println("User 3: ${user3.hashCode()}")
    var results = if (user3.equals(user2)) "Equal: ${user3.toString()} & ${user2.toString()}"
                    else "Not Equal: ${user3.toString()} & ${user2.toString()}"
    println(results)
    println()

    /**
     * 6. Data Class: Using Destructuring declarations
     * This is possible because the compiler creates componentN() to retrieve each member.
     */
    var car = Car("BMW", "i318", 2005)
    println("My car: ${car.toString()}")
    var (brand_, model_, year_) = car // it break down a class into a number of variables. variables
    // IMPORTANT: Breakdown of object into variables are done sequentially.
    // It means, in the same order defined as the primary cosntructor.
    // You can also retrieve values by using the component function
    println("Brand $brand_, and year $year_, and model ${car.component2()}")
    var car2 = Car("Mazda", "3 Series", 2018)
    println("Another car: ${car2.component1()}, ${car2.component2()}, ${car2.component3()}")

}