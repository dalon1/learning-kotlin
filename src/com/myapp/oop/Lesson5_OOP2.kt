package com.myapp.oop

/**
 * 1. Learning about Inheritance.
 * Inheritance: Key feature for OOP. Allows user to create one class from an existing one.
 * Derived class extends a Base class.
 * Code Quality: Cleaner, understandable and extendable.
 * NOTE: Classes in Kotlin are final by default. Therefore, a final class can't be subclassed or inherited from.
 * The keyword `open` is required to make a class as a base class.
 */

open class Person(name: String, age: Int) {
    init {
        println("Welcome to life, $name. Your age is $age!")
    }

    fun eat(food: String = "Air") {
        println("It is time to eat $food")
    }
}

class MathTeacher(name: String, age: Int = 0): Person(name, age) {
    fun teachMath() {
        println("As your math teacher, I'll teach you calculus today!")
    }
}
class Footballer(name: String, age: Int = 0): Person(name, age) {
    init {
        println("I'll be in the Champions league!")
    }
    fun playSoccer() {
        println("I'll defeat the real madrid today!")
    }
}

/**
 * 2. The derived class can have its own properties and functions.
 * In here, the NbaPlayer class has a property `team`.
 */
class NbaPlayer(name: String, age: Int = 18, var team: String = "UNKNOWN"): Person(name, age) {
    init {
        println("I play for the $team in the NBA. I'll make history")
    }

    fun play(opponent: String = "UNKNOWN") {
        println("Today, my team $team is playing against $opponent")
    }
}

/**
 * 3. Inheritance using a secondary constructor - NOT Primary.
 * The keyword `super`, each derive class needs to initialize the Base.
 */

open class OS {
    var name: String = "TBD"
    var rating: Int = 0

    init {
        print("A new OS is alive! ")
    }

    constructor(name_: String) {
        name = name_
        println("Welcome $name")
    }

    constructor(name_: String, rating_: Int = 0) {
        name = name_
        rating = rating_
        println("Welcome $name with rating $rating")
    }
}

class Windows : OS {
    constructor(name_: String) : super(name_) {}
    constructor(name_: String, rating_: Int): super(name_, rating_) {
        println("Using windows constructor")
    }

    fun runPowerShell() {
       println("I'm the only that can run powershell scripts ahaha.")
    }
}
class Ubuntu: OS {
    constructor(name: String): super(name) {
        println("I am a linux distro!")
    }
}

/**
 * 4. Using the keyword `override`
 */
open class MobileOs(name: String) {
    init {
        println("Welcome $name, a new mobile OS")
    }
    // The keyword open is important to make the member function as non-final.
    open fun downloadApp() {
        println("My apps are download from the internet!")
    }
}
class Android(name: String): MobileOs(name) {
    override fun downloadApp() {
        println("I download apps from the Google Play Store")
    }
}

class IOs(name:String): MobileOs(name) {
    override fun downloadApp() {
        super.downloadApp() // calling function of the base clas.
        println("I download apps from the Apple Store.")
    }
}

/**
 * 5. Using visibility modifiers
 * Affects: classes, constructors, properties, functions, interfaces and setters.
 * public, private, protected and internal
 */

/**
 * 5.1. Visibility inside a package (a collection of related classes, functions, properties.)
 * public - everywhere
 * private - inside the file that contains the declaration
 * internal - visible inside the same module
 * protected - not applicable for packages
 */

/**
 * 5.2. Visibility inside classes and interfaces.
 * public - everyone
 * private - inside the class only
 * internal - everyone inside the module
 * protected - visible to the class and its subclasses
 */

open class Parent() {
    init {
        println("learning about visibility!")
    }
    var a: String = "Everyone can see me!" // public default
    private var b: String = "No one can see me!" // Not visible outside class
    internal var c: String = "Only files inside the same module can see me"
    protected var d: String = "the base and derived classes can see me!" // Not visible outside class
}
class Child: Parent() {
    fun showMe() {
        println("The fields: \n\"$a\", \n\"$c\" and \n\"$d\" \nare visible ")
    }
    fun dontShowMe() {
        println("The fields b arent visible to me")
    }
}

/**
 * 5.3 Visibility for constructors.
 * Default is public.
 * To change the scope, you need to add the word `constructor`
 */
class Charger private constructor(var isOn: Boolean) {
    init {
        println("I am just a charger!")
    }
    fun isWorking() : String = if (isOn) "This is working" else "It is not working"
}

/**
 * 
 */

fun main(args : Array<String>) {
    /**
     * 1. Inheritance in action
     */
    var teacher : MathTeacher = MathTeacher("Diana")
    teacher.teachMath()

    println()

    /**
     * First the init block of Person runs
     * Second the init bloc of Footballer runs
     */
    var player: Footballer = Footballer("Messi", 30)
    player.playSoccer()
    player.eat("Falafel")

    println()

    /**
     * 2. Derived classes with its own properties and functions
     */
    var kawhi = NbaPlayer("Kawhi Leonard", 27, "Toronto Raptors")
    kawhi.play("LA Lakers")

    println()
    /**
     * 3. Inheritance using a secondary constructor.
     */
    var win = Windows("Windows 10", 99)
    win.runPowerShell()

    println()

    var ubuntu = Ubuntu("Ubuntu")

    /**
     * 4. Using the keyword `override` to override the behavior of a member function in a derived class.
     * Applicable to properties as well
     */
    println()
    Android("Android").downloadApp()
    println()
    IOs("iOS").downloadApp()

    /**
     * 5. Learning about visibility inside classes and interfaces
     */
    println()
    var p = Parent()
    var c = Child()
    c.showMe()
    c.dontShowMe()

    println()
    /**
     * 5.3 Because Charger's constructor is private, therefore it can't be instantiated
     */
    //var charger: Charger = Charger(true)
}