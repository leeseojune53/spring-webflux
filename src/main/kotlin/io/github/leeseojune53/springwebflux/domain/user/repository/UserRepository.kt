package io.github.leeseojune53.springwebflux.domain.user.repository

import io.github.leeseojune53.springwebflux.domain.user.User

interface UserRepository {

    fun isExistUserId(userId: String): Boolean

    fun registerUser(userId: String, password: String)

    fun getUserById(userId: String): User

}