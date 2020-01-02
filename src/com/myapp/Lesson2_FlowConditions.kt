package com.myapp

fun main(args : Array<String>) {

    /***
     * *************************************************************
     * FLOW CONDITIONAL STATEMENTS AND EXPRESSIONS
     * *************************************************************
     */
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

    // 1.1. More flow conditions if..else..if
    val age : Int = 18
    var isAlcoholLegal : String = if (age > 18) {
        println("Check.....ok")
        "You are ready to go my friend"
    } else if (age == 18) {
        println("Check.....ok")
        "You have the minimum age to drink"
    } else {
        println("Check....FAILURE")
        "Get the hell out of here!"
    }
    println("Drinking age msg: $isAlcoholLegal")

    // 2. nested expressions
    var rentingCarDiscount : Double = if (age >= 18) {
        if (age > 25) 25.0 else 15.0
    } else {
        println("No discount for you!")
        0.0
    }
    println("My car discount is $rentingCarDiscount")

    // 2. Kotlin "when" construct
    // "when" construct in Kotlin is a replacement for Java switch statement
    // If "when" is used as an expression, the else branch is a MUST
    val dayToday : String = "R"
    var dayFullName : String = when(dayToday) {
        "M" -> "Monday"
        "T" -> "Tuesday"
        "W" -> "Wednesday"
        "R" -> "Thursday"
        "F" -> "Friday"
        else -> "THIS IS NOT A DAY!"
    }
    println("What day is today? it is $dayFullName")

    when(rentingCarDiscount) {
        25.0 -> println("You already got the maximum discount!")
        15.0, 0.0 -> println("There is nothing else we can do about it !")
        else -> println("this is not even a discount")
    }

    // 2.1 checking value within range
    var myAgeMsg = when(age) {
        in 0..17 -> "Go back to school!"
        in 18..100 -> "You are an adult!!!!"
        else -> "not sure what your age is"
    }
    println("Age msg: $myAgeMsg")

    // 2.2 checking datatype of a variable
    when(age) {
        is Int -> println("Valid age")
        else -> println("This is not an age")
    }

    /***
     * *************************************************************
     * LOOPING
     * *************************************************************
     */

    // 1. while looping
    var i = 0
    while (i < 3) {
        println("Line $i")
        i++
    }
    i = 0
    var totalSum = 0
    while (i <= 100) {
        totalSum += i++
    }
    println("Total sum of 1 to 100 is $totalSum")

    // 2. do..while loop - the body is executed at least once!
    do {
        println("this gets executed at least once")
    } while(false)

    // Enter 3 grades and get the average
    i = 1
    var totalAvg : Double = 0.0
    /*do {
        print("Enter grade for score #$i: ")
        var input = readLine()!!
        totalAvg += input.toDouble()
        i++
    } while(i <= 3)*/
    println("Your average is ${totalAvg / 3}")


    //3. There is no traditional loop in kotlin for (i = 0, i < 1; i++)
    // Instead for loop is used to iterate through objects such as arrays, ranges and maps
    println("simple for loop output:")
    for (i in 1..5) println(i)
    println("for loop with step:  ")
    for (i in 1..5 step 2) println(i)
    println("for loop with reverse range: ")
    for (i in 5 downTo 1) println(i)
    println("for loo with reverse range and step: ")
    for (i in 5 downTo  1 step 2) println(i)

    //3.1 iterating through arrays
    var langs : Array<String> = arrayOf("python", "groovy", "kotlin")
    for (l in langs) println("My language is $l")
    // If an index is required, then you can do the following
    for (index in langs.indices) println(langs[index])

    totalSum = 0
    /*while(true) {
        print("Enter value: ")
        var input = readLine()!!.toInt()
        if (input == 0) break
        totalSum += input
    }*/
    println("Total sum received is $totalSum")

    //3. break and continue with labels

    first@ for (i in 1..100000) {
        second@ for (j in 1..3) {
            if (i == 100 && j % 2 == 0)  {
                println("i : $i and j: $j")
                break@first
            }
        }
    }


}