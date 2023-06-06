package io.github.leeseojune53.springwebflux.persistence.vote

import io.github.leeseojune53.springwebflux.persistence.entity.VoteEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface VoteReactiveDao : ReactiveCrudRepository<VoteEntity, String> {
}