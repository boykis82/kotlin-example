package com.example.demo

import com.example.demo.test.Book
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe

class GrammerTest : ShouldSpec({
    should("var test") {
        var a: Int
        a = 3
        a shouldBe 3
    }

    should("val test") {
        val a: Int
        // val a: Int = 5
        a = 3
        a shouldBe 3
    }

    should("type casting") {
        val a = 123
        val b = a.toString()

        b shouldBe "123"
    }

    should("array test") {
        val intArr = arrayOf(1,2,3,4)
        intArr.size shouldBe 4

        val nullArr = arrayOfNulls<Int>(5)
        nullArr.size shouldBe 5
    }

    should("condition") {
        val a = 5
        when(a) {
            5 -> a shouldBe 5
            4 -> a shouldBe 4
            else -> a shouldBe a
        }
    }

    should("apply") {
        val a = Book("a", 20000)
        a.apply {
            name = "apply $name"
            dc()
        }
        a.prettyName() shouldBe "apply a 18000"
    }

    should("also") {
        val a = Book("a", 20000)
        a.also {
            it.dc()
        }
        a.prettyName() shouldBe  "a 18000"
    }

    should("run") {
        val a = Book("a", 20000)
        val b = a.run {
            name = "apply $name"
            dc()
            prettyName()
        }
        b shouldBe "apply a 18000"
    }

    should("let") {
        val a = Book("a", 20000)
        val b = a.let {
            it.dc()
            it.prettyName()
        }
        b shouldBe "a 18000"
    }
}) {

    fun add(a: Int, b: Int) = a + b
    fun add2(a:Int, b: Int): Int {
        return a + b
    }
}