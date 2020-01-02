package com.myapp

/****
 * Kotlin supports both functional and object-oriented programming.
 * functional programming: high-order functions, function types and lambdas
 **/

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
fun main(args : Array<String>) {
    var l = Lamp()
    l.turnOn()
    l.turnOff()
    println(l.getStatus("dannel's lamp"))
}