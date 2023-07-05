package io.github.leeseojune53.springwebflux.config.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets

@Component
class JwtTokenProvider {

    companion object {
        private val TOKEN_HEADER = "Authorization"
        private val TOKEN_PREFIX = "Bearer"
        private val SECRET_KEY = "asdkfj#Kj812j3k*(sdkfjasqwercfjeijfdkd"
    }

    fun resolveToken(request: ServerHttpRequest): String? {
        val bearerToken = request.headers[TOKEN_HEADER]?.get(0)
        if (bearerToken.isNullOrEmpty() ||
            bearerToken.length < TOKEN_PREFIX.length
        ) {
            return null
        }
        return bearerToken.substring(TOKEN_PREFIX.length + 1)
    }

    fun authentication(token: String): Authentication {
        return UsernamePasswordAuthenticationToken.authenticated(
            User.withUsername(getUserIdByToken(token))
                .password("")
                .authorities(emptyList())
                .build(),
            token,
            emptyList()
        )
    }

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
            .signWith(getSecretKey())
            .compact()
    }

    fun getUserIdByToken(token: String): String {
        return getClaimByToken(token).subject
    }

    private fun getClaimByToken(token: String): Claims {
        return Jwts.parserBuilder()
            .setSigningKey(getSecretKey())
            .build()
            .parseClaimsJws(token)
            .body
    }

    private fun getSecretKey() = Keys.hmacShaKeyFor(SECRET_KEY.toByteArray(StandardCharsets.UTF_8))
}
