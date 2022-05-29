package com.example.demo

import com.example.demo.entity.Company
import com.example.demo.entity.CompanyRepository
import com.example.demo.entity.Employee
import com.example.demo.entity.EmployeeRepository
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

class MockTest : DescribeSpec() {
    private val companyRepository = mockk<CompanyRepository>()

    init {
        val expectedCompany = Company(1L, "A")

        this.describe("employee") {
            context("mocking") {
                it("return fake employee") {
                    every { companyRepository.findByIdOrNull(1) } answers { expectedCompany }

                    val foundCompany = companyRepository.findByIdOrNull(1)

                    foundCompany!!.id shouldBe 1
                    foundCompany.name shouldBe "A"
                }
            }
        }
    }

}