package com.example.demo

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.inspectors.forExactly
import io.kotest.matchers.shouldBe
import java.lang.ArithmeticException

class MyDescribeSpec : DescribeSpec({
    describe("Calculator") {
        context("1+2") {
            it("3") {
                1+2 shouldBe 3
            }
        }

        context("5-8") {
            it("-3") {
                5-8 shouldBe -3
            }
        }

        context("list test") {
            it("dup") {
                numbers.forExactly(3) {
                    it shouldBe 2
                }
            }

            it("once") {
                numbers.forExactly(1) {
                    it shouldBe 1
                }
            }
        }

        context("divide by zero") {
            it("throw an exception") {
                val exception = shouldThrow<ArithmeticException> {
                    throw ArithmeticException("aa")
                }
            }
        }
    }
})  {
    companion object {
        val numbers = listOf(
            1,2,3,4,5,2,2
        )

    }
}