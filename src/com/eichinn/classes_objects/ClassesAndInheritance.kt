package com.eichinn.classes_objects

fun main(args: Array<String>) {

}

/**
 * The class declaration consists of the class name, the class header(specifying its type parameters, the primary constructor etc)
 * and the class body,surrounded by curly braces.
 */
/*
class Customer<T> public @Inject constructor(name: String, val firstName: String, val lastName: String, var age: Int){

}
*/

/**
 * Both the header and the body are optional,if the class has no body, curly braces can be omitted.
 */
class Empty

open class Base(val name: String) {
    init {
        println("Initializing Base")
    }
}