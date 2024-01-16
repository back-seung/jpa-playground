package com.play.jpaplayground

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaPlaygroundApplication

fun main(args: Array<String>) {
    runApplication<JpaPlaygroundApplication>(*args)
}
