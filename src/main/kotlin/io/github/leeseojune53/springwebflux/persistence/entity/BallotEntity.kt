package io.github.leeseojune53.springwebflux.persistence.entity

import io.github.leeseojune53.springwebflux.domain.ballot.Ballot
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("ballot")
class BallotEntity(
    @Id
    var id: String?,
    val voteId: String,
    val userId: String,
    val target: String
): Persistable<String> {

    fun toDomain(): Ballot {
        return Ballot(
            id = id!!,
            voteId = voteId,
            userId = userId,
            target = target
        )
    }

    override fun getId(): String? {
        return id
    }

    override fun isNew(): Boolean {
        if(id == null) {
            id = UUID.randomUUID().toString()
            return true
        }
        return false
    }



}