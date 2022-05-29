package com.example.demo

import com.example.demo.entity.CompanyRepository
import com.example.demo.entity.EmployeeRepository
import io.kotest.core.extensions.Extension
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.every
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
internal class CompanyEmploteeRepositoryTest : DescribeSpec() {
    override fun extensions() = listOf(SpringExtension)

    @Autowired
    private lateinit var companyRepository: CompanyRepository

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    init {
        this.describe("company") {
            context("find by id(existing)") {
                it("return company") {
                    val employee = employeeRepository.findByIdOrNull(1L)

                    employee!!.id shouldBe 1
                    employee.name shouldBe "고길동"
                }
            }

            context("find by id - lazy loading") {
                it("...") {
                    val employee = employeeRepository.findByIdOrNull(2L)
                    employee!!.id shouldBe 2
                    employee.company!!.id shouldBe 2
                }
            }
        }
    }

}