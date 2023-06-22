package io.github.leeseojune53.springwebflux.domain.user.router

import io.github.leeseojune53.springwebflux.config.exception.ExceptionCode
import io.github.leeseojune53.springwebflux.config.exception.FluxException
import io.github.leeseojune53.springwebflux.domain.user.model.Token
import io.github.leeseojune53.springwebflux.domain.user.service.UserService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class UserHandler(
    private val userService: UserService
) {

    fun registerUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val result = serverRequest.bodyToMono(UserRequest::class.java)
            .flatMap {
                userService.registerUser(it.userId, it.password)
            }
        return ok().contentType(MediaType.APPLICATION_JSON).body(result, Token::class.java)
    }

    fun authUser(serverRequest: ServerRequest): Mono<ServerResponse> {
        val result = serverRequest.bodyToMono(UserRequest::class.java)
            .flatMap {
                userService.authUser(it.userId, it.password)
            }
        return ok().contentType(MediaType.APPLICATION_JSON).body(result, Token::class.java)
    }

    class UserRequest(
        val userId: String,
        val password: String
    )



}