package io.github.leeseojune53.springwebflux.persistence.user

import io.github.leeseojune53.springwebflux.domain.user.User
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import io.github.leeseojune53.springwebflux.persistence.entity.UserEntity
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class UserDao(
    private val userReactiveDao: UserReactiveDao
): UserRepository {
    override fun isExistUserId(userId: String): Mono<Boolean> {
        return userReactiveDao.existsById(userId)
    }

    override fun registerUser(userId: String, password: String) {
        userReactiveDao.save(UserEntity(userId, password))
    }

    override fun getUserById(userId: String): Mono<User> {
        return userReactiveDao.findById(userId)
            .map { it.toDomain() }
    }
}