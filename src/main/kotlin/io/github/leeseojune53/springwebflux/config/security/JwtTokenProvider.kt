package io.github.leeseojune53.springwebflux.config.security

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.stereotype.Component

@Component
class JwtTokenProvider {

    fun getAccessToken(userId: String): String {
        return createToken(userId, "access")
    }

    fun getRefreshToken(userId: String): String {
        return createToken(userId, "refresh")
    }

    private fun createToken(userId: String, tokenType: String): String {
        return Jwts.builder()
            .setSubject(userId)
            .claim("tokenType", tokenType)
                //TODO SecretKey
            .signWith(SignatureAlgorithm.HS256, "secretKey")
            .compact()
    }

}