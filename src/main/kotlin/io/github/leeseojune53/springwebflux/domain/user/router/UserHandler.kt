package io.github.leeseojune53.springwebflux.domain.user.router

import io.github.leeseojune53.springwebflux.config.exception.ExceptionCode
import io.github.leeseojune53.springwebflux.config.exception.FluxException
import io.github.leeseojune53.springwebflux.domain.user.service.UserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandler(
    private val userService: UserService
) {

    fun registerUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        TODO()
    }



}