package com.example.demo.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import au.com.console.kassava.kotlinEquals
import au.com.console.kassava.kotlinHashCode
import au.com.console.kassava.kotlinToString

@Entity
class Company(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String
    ) {

    override fun toString() = kotlinToString(properties = toStringProperties)

    override fun hashCode() = kotlinHashCode(properties = equalsAndHashCodeProperties)

    override fun equals(other: Any?) = kotlinEquals(other = other, properties = equalsAndHashCodeProperties)

    companion object {
        private val equalsAndHashCodeProperties = arrayOf(Company::id)
        private val toStringProperties = arrayOf(
            Company::id,
            Company::name
        )
}}