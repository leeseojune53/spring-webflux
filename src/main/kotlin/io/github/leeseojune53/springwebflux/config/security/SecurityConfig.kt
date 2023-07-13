package io.github.leeseojune53.springwebflux.config.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.SecurityWebFiltersOrder
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.server.SecurityWebFilterChain

@Configuration
@EnableWebFluxSecurity
class SecurityConfig(
    jwtTokenProvider: JwtTokenProvider
) {

    private val jwtTokenFilter = JwtTokenFilter(jwtTokenProvider)

    @Bean
    fun getPasswordEncoder() = BCryptPasswordEncoder()

    @Bean
    fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain {
        http.authorizeExchange { exchange ->
            exchange.pathMatchers("/users/**").permitAll()
            exchange.pathMatchers("/votes/**").permitAll()
            exchange.pathMatchers("/ballots/**").permitAll()
            exchange.anyExchange().authenticated()
        }
            .csrf().disable()
            .formLogin().disable()
            .httpBasic().disable()

        http.addFilterAt(jwtTokenFilter, SecurityWebFiltersOrder.AUTHENTICATION)

        return http.build()
    }
}
