package io.github.leeseojune53.springwebflux.domain.vote.service

import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.model.VoteElement
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class VoteService(
    private val voteRepository: VoteRepository
) {

    fun getVoteList(): Flux<VoteElement> {
        TODO()
    }

    fun getVoteStatus(voteId: String): Mono<VoteStatus> {
        TODO()
    }

}