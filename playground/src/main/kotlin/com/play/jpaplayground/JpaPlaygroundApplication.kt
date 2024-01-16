package com.play.jpaplayground

import com.play.jpaplayground.ch02_jpa_start1.MemberService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class JpaPlaygroundApplication {
    @Bean
    fun init(memberService: MemberService): CommandLineRunner {
        return CommandLineRunner {
            memberService.run()
        }
    }
}

fun main(args: Array<String>) {
    runApplication<JpaPlaygroundApplication>(*args)
}
