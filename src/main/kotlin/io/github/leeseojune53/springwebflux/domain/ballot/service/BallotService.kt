package io.github.leeseojune53.springwebflux.domain.ballot.service

import io.github.leeseojune53.springwebflux.domain.ballot.Ballot
import io.github.leeseojune53.springwebflux.domain.ballot.repository.BallotRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class BallotService(
    private val ballotRepository: BallotRepository
) {

    fun postBallot(voteId: String) {
        ballotRepository.save(Ballot(UUID.randomUUID().toString(), voteId, "temp", "temp"))
    }

    fun changeBallot() {
        TODO()
    }

    fun deleteBallot() {
        TODO()
    }

    fun isBalloted(): Boolean {
        TODO()
    }
}
