package com.example.demo

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class MyBehaviorSpec : BehaviorSpec({

  given("a") {
    `when`("b") {
      val result = 3 + 5
      then("c") {
        result shouldBe 8
      }
    }

    `when`("C") {
      val result = 5 - 3
      then("d") {
        result shouldBe 2
      }
    }

    `when`("d") {
      val result = 5 * 3
      then("e") {
        result shouldBe 15
      }
    }
  }
})