package io.github.leeseojune53.springwebflux.domain.ballot.service

import io.github.leeseojune53.springwebflux.domain.ballot.Ballot
import io.github.leeseojune53.springwebflux.domain.ballot.repository.BallotRepository
import org.springframework.security.core.context.ReactiveSecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class BallotService(
    private val ballotRepository: BallotRepository
) {

    fun postBallot(voteId: String, target: String): Mono<String> {
        return ReactiveSecurityContextHolder.getContext()
            .map { it.authentication.principal as UserDetails }
            .map { ballotRepository.save(Ballot(UUID.randomUUID().toString(), voteId, "hi", target)) }
            .map { "HIHI" }
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
