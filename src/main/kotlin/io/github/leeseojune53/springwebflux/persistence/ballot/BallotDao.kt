package io.github.leeseojune53.springwebflux.persistence.ballot

import io.github.leeseojune53.springwebflux.domain.ballot.repository.BallotRepository
import org.springframework.stereotype.Repository

@Repository
class BallotDao(
    private val ballotReactiveDao: BallotReactiveDao
): BallotRepository {


}