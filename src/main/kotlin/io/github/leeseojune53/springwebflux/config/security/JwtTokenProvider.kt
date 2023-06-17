package io.github.leeseojune53.springwebflux.config.security

import io.jsonwebtoken.Jwts
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider {

    fun createToken(userId: String): String {
        return Jwts.builder()
                //TODO
            .compact()
    }

}