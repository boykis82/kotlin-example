package com.example.demo.api

import com.example.demo.entity.Employee
import com.example.demo.entity.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EmployeeController @Autowired constructor(
    val employeeRepository: EmployeeRepository
) {
    @GetMapping("/")
    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()
}