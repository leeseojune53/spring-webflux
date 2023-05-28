package io.github.leeseojune53.springwebflux.domain.vote.service

import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.model.VoteElement
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository

class VoteService(
    private val voteRepository: VoteRepository
) {

    fun getVoteList(): List<VoteElement> {
        TODO()
    }

    fun getVoteStatus(voteId: String): VoteStatus {
        TODO()
    }

}