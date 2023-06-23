package io.github.leeseojune53.springwebflux.persistence.user

import io.github.leeseojune53.springwebflux.domain.user.User
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import io.github.leeseojune53.springwebflux.persistence.entity.UserEntity
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import java.util.*

@Repository
class UserDao(
    private val userReactiveDao: UserReactiveDao
) : UserRepository {
    override fun isExistUserId(userId: String): Mono<Boolean> {
        return userReactiveDao.existsByUserId(userId)
    }

    override fun registerUser(userId: String, password: String) {
        userReactiveDao.save(UserEntity(userId, password)).subscribe()
    }

    override fun getUserById(userId: String): Mono<User> {
        return userReactiveDao.findByUserId(userId)
            .map { it.toDomain() }
    }
}
