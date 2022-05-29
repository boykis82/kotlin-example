package com.example.demo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MyFunSpec : FunSpec({

  test("simple add") {
    1+2 shouldBe 3
  }
})