package io.github.leeseojune53.springwebflux.persistence.entity

import io.github.leeseojune53.springwebflux.domain.ballot.Ballot
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("ballot")
class BallotEntity(
    @Id
    var uuid: String?,
    val voteId: String,
    val userId: String,
    val target: String
): Persistable<String> {

    fun toDomain(): Ballot {
        return Ballot(
            id = uuid!!,
            voteId = voteId,
            userId = userId,
            target = target
        )
    }

    override fun getId(): String? {
        return uuid
    }

    override fun isNew(): Boolean {
        if(uuid == null) {
            uuid = UUID.randomUUID().toString()
            return true
        }
        return false
    }

    constructor(ballot: Ballot): this(ballot.id, ballot.voteId, ballot.userId, ballot.target)



}