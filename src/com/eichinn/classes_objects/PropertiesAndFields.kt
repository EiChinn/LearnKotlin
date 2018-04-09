package com.eichinn.classes_objects

import javax.xml.ws.soap.Addressing

class Adress {
    var name: String = "ei_chinn"
    var street:String = ""
    var city: String = ""
    var state: String = ""
    var zip: String = ""

    fun copyAdress(adress: Adress): Adress {
        val result = Adress() // there's no 'new' keyword in Kotlin
        result.name = adress.name //accessors are called
        result.street = adress.street
        result.city = adress.city
        result.state = adress.state
        result.zip = adress.zip
        return result
    }

    lateinit var allByDefault: String

    constructor(){
    }
}