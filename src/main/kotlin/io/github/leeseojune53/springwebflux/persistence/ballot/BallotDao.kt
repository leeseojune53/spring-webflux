package io.github.leeseojune53.springwebflux.persistence.ballot

import org.springframework.stereotype.Repository

@Repository
class BallotDao(
    private val ballotReactiveDao: BallotReactiveDao
) {


}