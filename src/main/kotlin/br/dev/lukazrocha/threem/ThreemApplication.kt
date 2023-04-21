package br.dev.lukazrocha.threem

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@SpringBootApplication
class ThreemApplication

fun main(args: Array<String>) {
    runApplication<ThreemApplication>(*args)
}
