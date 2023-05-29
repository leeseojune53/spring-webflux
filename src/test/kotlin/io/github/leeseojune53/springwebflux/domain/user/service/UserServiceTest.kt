package io.github.leeseojune53.springwebflux.domain.user.service

import io.github.leeseojune53.springwebflux.domain.user.User
import io.github.leeseojune53.springwebflux.domain.user.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
@DisplayName("UserService 테스트")
internal class UserServiceTest {

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var sut: UserService

    @DisplayName("유저_회원가입_성공")
    @Test
    fun 유저_회원가입_성공() {
        //given
        val userId = "test"
        val password = "test"

        //when
        Mockito.`when`(userRepository.isExistUserId(userId)).then { false }

        //then
        sut.registerUser(userId, password)
    }

    @DisplayName("유저_회원가입_아이디_중복_실패")
    @Test
    fun 유저_회원가입_아이디_중복_실패() {
        //given
        val userId = "test"
        val password = "test"

        //when
        Mockito.`when`(userRepository.isExistUserId(userId)).then { true }

        //then
        assertThrows(IllegalArgumentException::class.java) {
            sut.registerUser(userId, password)
        }
    }

    @DisplayName("유저_로그인_성공")
    @Test
    fun 유저_로그인_성공() {
        //given
        val userId = "test"
        val password = "test"

        //when
        Mockito.`when`(userRepository.isExistUserId(userId)).then { true }
        Mockito.`when`(userRepository.getUserById(userId)).then { User(userId, password) }

        //then
        val result = sut.authUser(userId, password)
        assertNotNull(result.accessToken)
        assertNotNull(result.refreshToken)
    }

    @DisplayName("유저_로그인_아이디_없음")
    @Test
    fun 유저_로그인_아이디_없음() {
        //given
        val userId = "test"
        val password = "test"

        //when
        Mockito.`when`(userRepository.isExistUserId(userId)).then { false }

        //then
        assertThrows(IllegalArgumentException::class.java) {
            sut.authUser(userId, password)
        }
    }

    @DisplayName("유저_로그인_비밀번호_불일치")
    @Test
    fun 유저_로그인_비밀번호_불일치() {
        //given
        val userId = "test"
        val password = "test"

        //when
        Mockito.`when`(userRepository.isExistUserId(userId)).then { true }
        Mockito.`when`(userRepository.getUserById(userId)).then { User(userId, "wrong") }

        //then
        assertThrows(IllegalArgumentException::class.java) {
            sut.authUser(userId, password)
        }
    }

}