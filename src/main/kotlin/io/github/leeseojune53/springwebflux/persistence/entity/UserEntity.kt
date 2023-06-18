package io.github.leeseojune53.springwebflux.persistence.entity

import io.github.leeseojune53.springwebflux.domain.user.User
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Table
import java.util.UUID

@Table("user")
class UserEntity(
    @Id
    var uuid: String?,
    val userId: String,
    val password: String
): Persistable<String> {

    constructor(userId: String, password: String): this(null, userId, password)

    fun toDomain(): User {
        return User(
            uuid = uuid!!,
            userId = userId,
            password = password
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

}