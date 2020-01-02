package com.myapp

fun main(args : Array<String>) {
    // 1. If expression - "if" condition returns a value in Kotlin
    var isSomething : Boolean = true
    if (isSomething) {
        println("Something is true!")
    } else {
        println("Something is false!")
    }

    // If returning value then both if & else must be used
    // the else branch is mandatory if using if as expression
    var lotteryMsg : String = if (true) {
        "YOU HAVE WON THE LOTTERY"
    } else {
        "You loser!"
    }
    println("Lottery Msg: $lotteryMsg")

    // Brackets are optional
    var isRandom : String = if (true) "Yes, it is random" else "No, it is not!"
    println(isRandom)
}