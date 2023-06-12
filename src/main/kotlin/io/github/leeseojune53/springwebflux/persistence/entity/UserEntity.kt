package io.github.leeseojune53.springwebflux.persistence.entity

import io.github.leeseojune53.springwebflux.domain.user.User
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user")
class UserEntity(
    @Id
    val id: String,
    val password: String
) {

    fun toDomain(): User {
        return User(
            id = id,
            password = password
        )
    }

}