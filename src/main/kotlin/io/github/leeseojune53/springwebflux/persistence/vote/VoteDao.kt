package io.github.leeseojune53.springwebflux.persistence.vote

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
class VoteDao(
    private val voteReactiveDao: VoteReactiveDao
) : VoteRepository {
    override fun getVoteList(): Flux<Vote> {
        return voteReactiveDao.findAll()
            .map { it.toDomain() }
    }

    override fun getVoteStatus(id: String): Mono<VoteStatus> {
        return voteReactiveDao.findById(id)
            .map { it.status }
    }
}
