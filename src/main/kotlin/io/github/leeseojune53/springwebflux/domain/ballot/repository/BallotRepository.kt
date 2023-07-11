package io.github.leeseojune53.springwebflux.domain.ballot.repository

import io.github.leeseojune53.springwebflux.domain.ballot.Ballot

interface BallotRepository {
    fun save(ballot: Ballot)
}