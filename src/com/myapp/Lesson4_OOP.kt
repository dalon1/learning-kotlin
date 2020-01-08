package com.myapp

/****
 * Kotlin supports both functional and object-oriented programming.
 * functional programming: high-order functions, function types and lambdas
 **/

/**
 * 1. Learning about creating classes, properties (states) and functions (behaviours)
 */
class Lamp {
    /**
     * Note about properties: It must be initialized with a value, or declared to abstract.
     */
    private var isOn : Boolean = false
    fun turnOn() {
        println("I am ON!")
        isOn = true
    }
    fun turnOff() {
        println("I am OFF!")
        isOn = false
    }
    fun getStatus(name : String = "") : String = if (isOn) "the lamp $name is ON" else "the lamp $name is OFF"

}

/**
 * 2. Learning about constructors -- Primary and secondary constructors
 * constructor --> initialize class properties
 * Primary constructor: concise way to initialize a class. It is part of the class header.
 * Secondary constructor: allows you to put additional initialization logic
 */
// Primary constructor example >>
class Student(val name: String, var age: Int) {}

/**
 * 3. Primary Constructor and init block.
 * Allows you to add logic and modify properties within initialization.
 */
class School(_name: String, _location: String) {
    val name : String
    var location : String
    // Another option could have been...
    //val name: String = name_.capitalize()
    //var location: String = location_.capitalize()

    // The init block lets me put more logic in the constructor.
    init {
        name = _name.capitalize()
        location = _location.capitalize()
        println("School Description: ${name} @ ${location}")
    }
}

/**
 * 4. Default value in primary constructor.
 */
class Car(var model: String = "UNKNOWN", var year: Int = 2000) {
    init {
        println("Car Description: ${model} @ ${year}")
    }
}

/**
 * 5. Secondary constructors
 * It allows classes to have one or more constructors.
 * It uses the `constructor` keyword. Not common in Kotlin
 */
class Call {
    constructor(network: String, origin: String) {
        println("Call #1 - Description: ${network}, ${origin}")
    }
    constructor(network: String, origin: String, user: String) {
        println("Call #2 - Description: ${network}, ${origin} by ${user}")
    }
}

/**
 * 6. Getters and setters are OPTIONAL & auto-generated.
 * Getters and setters behaviours can be modified
 */
class Battery(var percentage:Int = 0) {
    var status:String = "UNKNOWN"
    get() = field
    set(value) {
        field = if (percentage >  50) {
            "OK"
        } else if (percentage > 20) {
            "Almost There"
        }
        else {
            "DYING!!"
        }
    }
    init {
        status = "tmp_value"
        println("Creating a new battery")
    }
    fun isBatteryOk() {
        println("Battery Status: ${status}")
    }
}

fun main(args : Array<String>) {
    // 1. Creating classes
    var l = Lamp()
    l.turnOn()
    l.turnOff()
    println(l.getStatus("dannel's lamp"))

    // 2. Primary constructor
    val student : Student = Student("Dannel", 24)
    println("Student Name: ${student.name}")
    println("Student Age: ${student.age}")

    // 3. init block
    val school: School = School("colegio Isaac Rabin", "clayton, Panama City, Panama")

    // 4. constructor default parameters
    val myCar: Car = Car(year = 2019)
    var bmw: Car = Car(model = "BMW")

    // 5. Using secondary constructor
    var myCall: Call = Call("Rogers", "CANADA")
    myCall= Call("Rogers", "CANADA", "dannel")

    // 6. Modifying getters
    var battery: Battery = Battery(10)
    battery.isBatteryOk()

}