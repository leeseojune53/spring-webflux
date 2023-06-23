package io.github.leeseojune53.springwebflux.domain.user

import java.util.UUID

class User(
    val uuid: UUID,
    val userId: String,
    val password: String
) {
    constructor(uuid: String, userId: String, password: String) : this(UUID.fromString(uuid), userId, password)
}
