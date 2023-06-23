package io.github.leeseojune53.springwebflux.domain.vote.repository

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface VoteRepository {
    fun getVoteList(): Flux<Vote>
    fun getVoteStatus(id: String): Mono<VoteStatus>
}
