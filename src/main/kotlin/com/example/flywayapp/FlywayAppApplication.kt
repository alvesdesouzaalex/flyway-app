package com.example.flywayapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class FlywayAppApplication

fun main(args: Array<String>) {
    runApplication<FlywayAppApplication>(*args)
}
