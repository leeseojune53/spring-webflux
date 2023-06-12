package io.github.leeseojune53.springwebflux.persistence.entity

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("vote")
class VoteEntity(
    @Id
    val id: String,
    //TODO Enum으로 변경
    val status: String
) {

    fun toDomain(): Vote {
        return Vote(
            id = id,
            status = VoteStatus.valueOf(status)
        )
    }

}