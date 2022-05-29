package com.example.demo.test

class Book(var name: String, var price: Int) {
    fun dc() {
        price -= 2000
    }

    fun prettyName() : String {
        return "$name $price"
    }
}