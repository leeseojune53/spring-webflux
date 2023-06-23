package io.github.leeseojune53.springwebflux.domain.vote.service

import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.model.VoteElement
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class VoteService(
    private val voteRepository: VoteRepository
) {

    fun getVoteList(): Flux<VoteElement> {
        return voteRepository.getVoteList()
            .map { VoteElement(it.id, it.status) }
    }

    fun getVoteStatus(voteId: String): Mono<VoteStatus> {
        return voteRepository.getVoteStatus(voteId)
    }
}
