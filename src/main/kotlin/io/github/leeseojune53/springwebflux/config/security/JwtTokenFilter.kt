package io.github.leeseojune53.springwebflux.config.security

import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.web.server.ServerWebExchange
import org.springframework.web.server.WebFilter
import org.springframework.web.server.WebFilterChain
import reactor.core.publisher.Mono

class JwtTokenFilter(
    private val jwtTokenProvider: JwtTokenProvider
) : WebFilter {

    override fun filter(exchange: ServerWebExchange, chain: WebFilterChain): Mono<Void> {
        val token = jwtTokenProvider.resolveToken(exchange.request)
        if (token != null) {
            val authentication = jwtTokenProvider.authentication(token)
            return ReactiveSecurityContextHolder.getContext().map { context -> context.authentication = authentication }.then(chain.filter(exchange))
        }

        return chain.filter(exchange)
    }
}
