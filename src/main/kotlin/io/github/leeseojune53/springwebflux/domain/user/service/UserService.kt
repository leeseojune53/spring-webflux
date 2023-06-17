package io.github.leeseojune53.springwebflux.domain.user.service

import io.github.leeseojune53.springwebflux.config.exception.ExceptionCode
import io.github.leeseojune53.springwebflux.config.exception.FluxException
import io.github.leeseojune53.springwebflux.config.security.JwtTokenProvider
import io.github.leeseojune53.springwebflux.domain.user.model.Token
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val jwtTokenProvider: JwtTokenProvider,
) {

    fun registerUser(userId: String, password: String): Mono<Token> {
        return userRepository.isExistUserId(userId)
            .map {
                if (it) throw FluxException(ExceptionCode.BAD_REQUEST, "이미 존재하는 아이디입니다.")
            }
            .map {
                userRepository.registerUser(userId, passwordEncoder.encode(password))
                // TODO JwtTokenProvider
                Token(jwtTokenProvider.createToken(userId), jwtTokenProvider.createToken(userId))
            }
    }

    fun authUser(userId: String, password: String): Mono<Token> {
        TODO()
    }

}