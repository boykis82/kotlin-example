package com.example.demo

import com.example.demo.entity.Company
import com.example.demo.entity.Employee
import com.example.demo.entity.EmployeeRepository
import com.ninjasquad.springmockk.MockkBean
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.getForObject
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import javax.swing.Spring

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    private lateinit var restTemplate: TestRestTemplate

    @MockkBean
    private lateinit var employeeRepository: EmployeeRepository

    init {
        this.beforeTest {
            val a = 1
        }

        this.afterTest { (test, result) ->
            val b = 1
        }


        this.describe("API") {
            context("find all employees") {
                it("aaa") {
                    every { employeeRepository.findAll() } answers { allEmployees }

                    val response = restTemplate.getForObject<List<Employee>>("/")

                    response!!.size shouldBe 3
                }
            }
        }
    }

    companion object {
        private val aCompany = Company(1L, "A")
        private val allEmployees = listOf(
            Employee(1L,"A", aCompany),
            Employee(2L,"B", aCompany),
            Employee(3L,"B", aCompany),
        )
    }
}