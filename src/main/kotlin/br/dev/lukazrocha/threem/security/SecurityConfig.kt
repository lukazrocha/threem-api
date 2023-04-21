package br.dev.lukazrocha.threem.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfigurationSource

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val corsConfigurationSource: CorsConfigurationSource,
) {

    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http.cors().configurationSource(corsConfigurationSource)
        return http.build()
    }
}
