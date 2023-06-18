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
                true
            }
            .map {
                userRepository.registerUser(userId, passwordEncoder.encode(password))
                Token(jwtTokenProvider.getAccessToken(userId), jwtTokenProvider.getRefreshToken(userId))
            }
    }

    fun authUser(userId: String, password: String): Mono<Token> {
        return userRepository.getUserById(userId)
            .map { user ->
                if (!passwordEncoder.matches(password, user.password)) throw FluxException(ExceptionCode.BAD_REQUEST, "비밀번호가 일치하지 않습니다.")
                Token(jwtTokenProvider.getAccessToken(userId), jwtTokenProvider.getRefreshToken(userId))
            }
            .switchIfEmpty(Mono.error(FluxException(ExceptionCode.BAD_REQUEST, "존재하지 않는 아이디입니다.")))
    }

}