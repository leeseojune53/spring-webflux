package io.github.leeseojune53.springwebflux.persistence.ballot

import io.github.leeseojune53.springwebflux.persistence.entity.BallotEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface BallotReactiveDao: ReactiveCrudRepository<BallotEntity, String> {
}