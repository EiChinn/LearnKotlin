package com.eichinn.getting_started

fun main(args: Array<String>) {
    println("Idioms")
}

/**
 * Creating DTOs(POJOs/POCOs)
 * provides a customer class with the following functionality:
 * - getters(and setters in cast of var) for all properties
 * - equals()
 * - hashCode()
 * - toString()
 * - copy()
 * - component1(), component2(), ..., for all properties
 */
data class Customer(val name: String, val email: String)

/* Default values for function parameters */
fun foo(a: Int = 0, s: String = ""){
    //...
}