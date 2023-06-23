package io.github.leeseojune53.springwebflux.domain.vote.model

import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus

class VoteElement(
    val id: String,
    val status: VoteStatus
)
