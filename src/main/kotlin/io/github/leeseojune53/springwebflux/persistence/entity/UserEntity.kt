package io.github.leeseojune53.springwebflux.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("user")
class UserEntity(
    @Id
    val id: String,
    val password: String
) {
}