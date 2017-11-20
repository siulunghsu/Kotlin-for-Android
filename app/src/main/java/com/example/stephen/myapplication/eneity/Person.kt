package com.example.stephen.myapplication.eneity

/**
 * Created by stephen on 2017/10/28.
 */
//class Person(name: String, age: String) : Animal(name)

class Person{
//    var name: String = ""
    var name: String = ""
    get() = field.toUpperCase()
    set(value) {
        field = "Name: $value"
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    
}