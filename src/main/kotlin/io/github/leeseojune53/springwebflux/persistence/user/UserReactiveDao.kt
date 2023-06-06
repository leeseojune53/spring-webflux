package io.github.leeseojune53.springwebflux.persistence.user

import io.github.leeseojune53.springwebflux.persistence.entity.UserEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface UserReactiveDao: ReactiveCrudRepository<UserEntity, String> {}