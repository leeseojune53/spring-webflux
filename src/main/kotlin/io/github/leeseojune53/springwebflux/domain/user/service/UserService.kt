package io.github.leeseojune53.springwebflux.domain.user.service

import io.github.leeseojune53.springwebflux.domain.user.model.Token
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository

class UserService(
    private val userRepository: UserRepository
) {

    fun registerUser(userId: String, password: String): Token {
        TODO()
    }

    fun authUser(userId: String, password: String): Token {
        TODO()
    }

}