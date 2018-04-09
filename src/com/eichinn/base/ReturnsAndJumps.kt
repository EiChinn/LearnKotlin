package com.eichinn.base

import com.eichinn.getting_started.foo


fun main(vararg args: String) {
    /*
    Break and Continue labels
     */
    loop@ for (i in 1..10) {
        for (j in 1..10) {
            if (j > 5) {
                break@loop
//                continue@loop
            }
            println("$i : $j")
        }
    }

    /*
     * Return at labels
     */
//    foo()
//    foo1()
//    foo2()
//    foo3()
    foo4()

    //When returning a value, the parser gives preference to the qualified return, i.e.:
//    return@a 1
    //means "return 1 at label @a" , and not "return a labeled expression (@ 1)"
}



/**
 * With function literals, local functions and object expression, functions can be nested in Kotlin.
 * Qualified returns allow us to return from an outer function.The most important use case is returning from
 * a lambda expression.
 */
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach{
        if (it == 3) {
            return //non-local return directly to the caller of foo()
        }
        print(it)
    }
    print("this point is unreachable")

}

/**
 * The return-expression returns from the nearest enclosing function, i.e. foo.(Note that such non-local returns are
 * supported only for lambda expressions passed to inline-functions.) If we need to return from a lambda expression,
 * we hava to label it and qualify the return.
 *
 */
fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) {
            return@lit //local return to the caller of lambda,i.e.the forEach loop
        }
        print(it)
    }

    print(" done with explicit label")
}

/**
 * Oftentimes it's more convenient to us implicit labels: such a label has the same name as the function to which
 * the lambda is passed.
 */
fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) {
            return@forEach //local return to the caller of lambda, i.e.the forEach loop
        }
        print(it)
    }
    print(" done with implicit label")
}

/**
 * Alternatively, we can replaced the lambda expression with an anonymous function.A return statement in an anonymous
 * function will return from the anonymous function itself.
 */
fun foo3() {
    listOf(1, 2, 3, 4, 5).forEach(fun(it: Int){
        if (it == 3) {
            //!break;//'break' and 'continue' are only allowed inside a loop
            return //local return to the caller of anonymous function, i.e.the forEach loop
        }
        print(it)
    })
    print(" done with anonymous function")
}

/**
 * Note that the use of local returns in previous three samples is similar to the use of 'continue' in regular loops.
 * There is no direct equivalent for 'break'. but it can be simulated by adding another nesting lambda and non-locally
 * returning from it.
 */
fun foo4() {
    run {
        listOf(1, 2, 3, 4, 5).forEach{
            if (it == 3) {
                return@run //non-local return from the lambda passed to run
            }
            print(it)
        }
    }
    print(" done with nested loop")
}