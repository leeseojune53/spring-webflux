package io.github.leeseojune53.springwebflux.domain.user.service

import io.github.leeseojune53.springwebflux.config.exception.FluxException
import io.github.leeseojune53.springwebflux.config.security.JwtTokenProvider
import io.github.leeseojune53.springwebflux.domain.user.User
import io.github.leeseojune53.springwebflux.domain.user.model.Token
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.security.crypto.password.PasswordEncoder
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@ExtendWith(MockitoExtension::class)
@DisplayName("UserService 테스트")
internal class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @Mock
    lateinit var passwordEncoder: PasswordEncoder

    @Mock
    lateinit var jwtTokenProvider: JwtTokenProvider

    @InjectMocks
    lateinit var sut: UserService

    @DisplayName("유저_회원가입_성공")
    @Test
    fun 유저_회원가입_성공() {
        //given
        val userId = "test"
        val password = "test"
        val token = "token"
        given(userRepository.isExistUserId(userId)).willReturn(Mono.just(false))
        given(passwordEncoder.encode(password)).willReturn(password)
        given(jwtTokenProvider.createToken(userId)).willReturn(token)

        //when
        val result = sut.registerUser(userId, password)

        //then
        StepVerifier.create(result)
            .assertNext { tokenResult ->
                assertEquals(token, tokenResult.accessToken)
                assertEquals(token, tokenResult.refreshToken)
            }
            .verifyComplete()
    }

    @DisplayName("유저_회원가입_아이디_중복_실패")
    @Test
    fun 유저_회원가입_아이디_중복_실패() {
        //given
        val userId = "test"
        val password = "test"
        given(userRepository.isExistUserId(userId)).willReturn(Mono.just(true))

        //when
        val result = sut.registerUser(userId, password)

        //then
        StepVerifier.create(result)
            .expectError(FluxException::class.java)
            .verify()
    }

    @DisplayName("유저_로그인_성공")
    @Test
    fun 유저_로그인_성공() {
        //given
        val userId = "test"
        val password = "test"
        val token = "token"
        given(userRepository.isExistUserId(userId)).willReturn(Mono.just(true))
        given(userRepository.getUserById(userId)).willReturn(Mono.just(User(userId, password)))
        given(jwtTokenProvider.createToken(userId)).willReturn(token)

        //when
        val result = sut.authUser(userId, password)


        //then
        StepVerifier.create(result)
            .assertNext { tokenResult ->
                assertEquals(token, tokenResult.accessToken)
                assertEquals(token, tokenResult.refreshToken)
            }
            .verifyComplete()
    }

    @DisplayName("유저_로그인_아이디_없음")
    @Test
    fun 유저_로그인_아이디_없음() {
        //given
        val userId = "test"
        val password = "test"
        given(userRepository.isExistUserId(userId)).willReturn(Mono.just(false))

        //when
        val result = sut.authUser(userId, password)

        //then
        StepVerifier.create(result)
            .expectError(IllegalArgumentException::class.java)
            .verify()
    }

    @DisplayName("유저_로그인_비밀번호_불일치")
    @Test
    fun 유저_로그인_비밀번호_불일치() {
        //given
        val userId = "test"
        val password = "test"
        given(userRepository.isExistUserId(userId)).willReturn(Mono.just(true))
        given(userRepository.getUserById(userId)).willReturn(Mono.just(User(userId, "wrong")))

        //when
        val result = sut.authUser(userId, password)

        //then
        StepVerifier.create(result)
            .expectError(IllegalArgumentException::class.java)
            .verify()
    }

}