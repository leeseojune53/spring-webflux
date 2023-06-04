package io.github.leeseojune53.springwebflux.domain.user.service

import io.github.leeseojune53.springwebflux.domain.user.model.Token
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun registerUser(userId: String, password: String): Mono<Token> {
        TODO()
    }

    fun authUser(userId: String, password: String): Mono<Token> {
        TODO()
    }

}