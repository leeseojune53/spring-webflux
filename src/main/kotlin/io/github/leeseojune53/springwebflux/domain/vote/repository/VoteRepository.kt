package io.github.leeseojune53.springwebflux.domain.vote.repository

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus

interface VoteRepository {
    fun getVoteList(): List<Vote>
    fun getVoteStatus(id: String): VoteStatus
}