package io.github.leeseojune53.springwebflux.persistence.ballot

import io.github.leeseojune53.springwebflux.domain.ballot.Ballot
import io.github.leeseojune53.springwebflux.domain.ballot.repository.BallotRepository
import io.github.leeseojune53.springwebflux.persistence.entity.BallotEntity
import org.springframework.stereotype.Repository

@Repository
class BallotDao(
    private val ballotReactiveDao: BallotReactiveDao
): BallotRepository {

    override fun save(ballot: Ballot) {
        ballotReactiveDao.save(BallotEntity(ballot)).subscribe()
    }


}