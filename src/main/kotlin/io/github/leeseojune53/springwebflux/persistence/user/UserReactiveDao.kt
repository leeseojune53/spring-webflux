package io.github.leeseojune53.springwebflux.persistence.user

import io.github.leeseojune53.springwebflux.persistence.entity.UserEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono
import java.util.UUID

interface UserReactiveDao: ReactiveCrudRepository<UserEntity, UUID> {
    fun existsByUserId(userId: String): Mono<Boolean>
    fun findByUserId(userId: String): Mono<UserEntity>
}