package io.github.leeseojune53.springwebflux.persistence.vote

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository
import org.springframework.stereotype.Repository

@Repository
class VoteDao(
    private val voteReactiveDao: VoteReactiveDao
): VoteRepository {
    override fun getVoteList(): List<Vote> {
        TODO("Not yet implemented")
    }

    override fun getVoteStatus(id: String): VoteStatus {
        TODO("Not yet implemented")
    }
}