package io.github.leeseojune53.springwebflux.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("vote")
class VoteEntity(
    @Id
    val id: String,
    val status: String
) {
}