package io.github.leeseojune53.springwebflux.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig  {

    @Bean
    fun getPasswordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain = http
        .csrf().disable()
        .formLogin().disable()
        .httpBasic().disable()
        .authorizeExchange()
        .pathMatchers("/users/**").permitAll()
        .pathMatchers("/votes/**").permitAll()
        .anyExchange().authenticated()
        .and()
        .build()



}