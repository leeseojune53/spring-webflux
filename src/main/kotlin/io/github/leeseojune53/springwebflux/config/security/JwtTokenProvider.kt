package io.github.leeseojune53.springwebflux.config.security

import io.jsonwebtoken.Claims
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
            // TODO SecretKey
            .signWith(SignatureAlgorithm.HS256, "secretKey".toByteArray())
            .compact()
    }

    fun getUserIdByToken(token: String): String {
        return getClaimByToken(token).subject
    }

    fun getClaimByToken(token: String): Claims {
        return Jwts.parser()
            .setSigningKey("secretKey".toByteArray())
            .parseClaimsJws(token)
            .body
    }

}
