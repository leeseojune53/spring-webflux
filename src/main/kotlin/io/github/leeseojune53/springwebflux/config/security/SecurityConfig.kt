package io.github.leeseojune53.springwebflux.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableWebFluxSecurity
class SecurityConfig {

    @Bean
    fun getPasswordEncoder() = BCryptPasswordEncoder()


}