package com.eichinn.base

fun main(vararg args: String) {
    /*
    if expression
    */
    val a = 1
    val b = 2
    //Traditional usage
    var max = a
    if(a < b) max = b

    //With else
    if (a > b) {
        max = a
    } else {
        max = b
    }
    //As expression
    max = if (a > b) a else b
    max = if (a > b) {
        print("choose a")
        a
    } else {
        print("choose b")
        b
    }

    /*
    Whe Expression
     */
    var x = 1
    when(x) {
        0,1 -> print("x == 0 or x == 1")
        2 -> print("x == 2")
//        parseInt(s) -> print("s encodes x")
        in 1..10 -> print("")
        !in 10..20 -> print("")
//        in validNumbers - > print("")
//        is String -> print("")
//        !is String -> print("")
        else -> {
            print("otherwise")
        }
    }

    //replace if-else chain
    when {
//        x.isOdd() -> print("")
//        x.isEven() -> print("")
        else -> print("")
    }

    /*
    For loop
     */
    // for (item in collection) print(item)
    /*
    for (item: Int in ints) {
        //
    }
     */
    val array = arrayOf(1)
    for (i in 1..3) print(i)
    for (i in 6 downTo 0 step 2) print(i)
    for (i in array.indices) print(array[i])
    for ((index, value) in array.withIndex()) print("the element at $index is $value")

    /*
    While loop
     */
    while (x > 0) {
        x--
    }
    /*do {
        val y = retrieveData()
    } while (y != null) //y is visible here!*/
}
