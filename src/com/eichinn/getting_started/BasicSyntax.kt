package com.eichinn.getting_started

/*
Top-level variables(outside of any class in a kotlin file, may be):
 */
val PI = 3.14
var x = 1
fun increamtX() {
    x += 1
}

fun main(args: Array<String>) {//This is an end-of-line comment
    /*
    This is a block comment on multiple lines.
    /*Unlike java, block comment in Kotlin can be nested */*/


    /*
    Defining variables
    */
    //Assign-once(read-only) local variable
    val a: Int = 1//immediate assignment
    val b = 2 //'Int' type is inferred
    val c: Int //Type required when no initializer is provided
    c = 3 //deferred assignment

    //Mutable variable
    var x = 5 //'Int' type is inferred
    x += 1

    /*
    Using string templates
    */
    var d = 1
    //simple name in template:
    val s1 = "d is $d"
    d = 2
    //arbitrary expression in template:
    val s2 ="${s1.replace("is", "was")}, but now is $d"

    /*
    Using a loop
     */
    val items = listOf("apple", "banana", "kiwifruit")
    //for loop
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    //while loop
    var index = 0
    while (index < items.size) {
        println("item at $index is ${items[index]}")
        index++
    }

    /*
    Using ranges
     */
    val e = 10
    val f = 9
    if (e in 1..f+1) {
        println("fits in ranges")
    }
    val list = listOf("a", "b", "c")
    if (-1 !in 1..list.lastIndex) {
        println("-1 is out of range")
    }
    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
    for (x in 1..5) {
        println(x)
    }
    for (x in 1..10 step 2) {
        println(x)
    }
    for (x in 9 downTo 0 step 3) {
        println(x)
    }

    /*
    Using collections
     */
    val fruits = listOf("apple", "orange", "banana", "kiwifruit", "avocado")
    for (fruit in fruits) {
        println(fruit)
    }
    when {
        "orange" in fruits -> println("Juicy")
        "apple" in fruits -> println("apple is fine too")
    }
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach{println(it)}

    /*
    Creating basic classes and their instance
     */
    val rectangle = Rectangle(5.0, 2.0)//no 'new' keyword required
    val triangle = Triangle(3.0, 4.0, 5.0)
}

/*
Defining functions
*/
fun sum1(a: Int, b: Int): Int {
    return a + b
}
//function with an expression body and inferred return type
fun sum2(a: Int, b: Int) = a + b
//function returning no meaningful value
fun printSum1(a: Int, b: Int): Unit {
    print("sum of $a and $b is ${a + b}")
}
//Unit return type can be omitted
fun printSum2(a: Int, b: Int) {
    print("sum of $a and $b is ${a + b}")
}

/*
Using conditional expressions
*/
fun maxOf1(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
//using if as an expression
fun maxOf2(a: Int, b: Int) = if (a > b) a else b

/*
Using nullable values and checking for null
 */
fun parseInt(str: String): Int? {
    //...
    return null
}
fun printProduct1(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    //Using x * y yields error because they may hold nulls
    //println(x * y)
    if (x != null && y != null) {
        //x and y are automatically cast to non-null after null check
        println(x * y)
    } else {
        println("either $arg1 or $arg2 is not a number")
    }
}
fun printProduct(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)

    if (x == null) {
        println("Wrong number format in arg1: $arg1")
        return
    }
    if (y == null) {
        println("Wrong number format in arg2: $arg2")
        return
    }
    //x and y are automatically cast to non-null after null check
    println(x * y)
}

/*
Using type checks and automatic casts
 */
fun getStringLength1(obj: Any): Int? {
    if (obj is String) {
        //'obj' is automatically cast to 'String' in this branch
        return obj.length
    }
    //'obj' is still of type 'Any' outside of the type-checked branch
    return null
}
fun getStringLength2(obj: Any): Int? {
    if (obj !is String) return null
    //'obj' is automatically cast to 'String' in this branch
    return obj.length
}
fun getStringLength3(obj: Any): Int? {
    //'obj' is automatically cast to 'String' on the right-hand side of '&&'
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

/*
Using when expression
 */
fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

//Defining classes
class Rectangle(width: Double, height: Double)
class Triangle(a: Double, b: Double, c: Double)




