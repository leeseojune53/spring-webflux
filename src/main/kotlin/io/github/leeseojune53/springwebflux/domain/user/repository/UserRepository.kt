package io.github.leeseojune53.springwebflux.domain.user.repository

import io.github.leeseojune53.springwebflux.domain.user.User
import reactor.core.publisher.Mono

interface UserRepository {

    fun isExistUserId(userId: String): Mono<Boolean>

    fun registerUser(userId: String, password: String)

    fun getUserById(userId: String): Mono<User>
}
