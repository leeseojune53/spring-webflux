package io.github.leeseojune53.springwebflux.domain.vote

import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus

class Vote(
    val id: String,
    val status: VoteStatus
)
