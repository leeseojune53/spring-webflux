package io.github.leeseojune53.springwebflux.persistence.user

import io.github.leeseojune53.springwebflux.domain.user.User
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository

@Repository
class UserDao(
    private val userReactiveDao: UserReactiveDao
): UserRepository {
    override fun isExistUserId(userId: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun registerUser(userId: String, password: String) {
        TODO("Not yet implemented")
    }

    override fun getUserById(userId: String): User {
        TODO("Not yet implemented")
    }
}