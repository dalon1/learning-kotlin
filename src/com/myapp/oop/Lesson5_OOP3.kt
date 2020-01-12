package com.myapp.oop

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
}