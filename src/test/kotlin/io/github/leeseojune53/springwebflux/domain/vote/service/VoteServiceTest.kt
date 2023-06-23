package io.github.leeseojune53.springwebflux.domain.vote.service

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.given
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier

@ExtendWith(MockitoExtension::class)
@DisplayName("VoteService 테스트")
internal class VoteServiceTest {

    @Mock
    lateinit var voteRepository: VoteRepository

    @InjectMocks
    lateinit var sut: VoteService

    @DisplayName("투표 목록을 조회할 수 있다.")
    @Test
    fun 투표_목록_조회_성공() {
        // given
        val vote = Vote("1", VoteStatus.PREPARE)
        given(voteRepository.getVoteList()).willReturn(Flux.just(vote))

        // when
        val result = sut.getVoteList()

        // then
        StepVerifier.create(result)
            .assertNext {
                assertThat(it.id).isEqualTo(vote.id)
                assertThat(it.status).isEqualTo(vote.status)
            }
            .verifyComplete()
    }

    @DisplayName("투표 빈 목록을 조회할 수 있다.")
    @Test
    fun 투표_빈_목록() {
        // given
        given(voteRepository.getVoteList()).willReturn(Flux.just())

        // when
        val result = sut.getVoteList()

        // then
        StepVerifier.create(result)
            .expectNextCount(0L)
            .verifyComplete()
    }

    @DisplayName("투표 상태를 조회할 수 있다.")
    @Test
    fun 투표_상태_조회_성공() {
        // given
        val vote = Vote("1", VoteStatus.PREPARE)
        given(voteRepository.getVoteStatus(vote.id)).willReturn(Mono.just(vote.status))

        // when
        val resultStatus = sut.getVoteStatus(vote.id)

        // then
        StepVerifier.create(resultStatus)
            .expectNext(vote.status)
            .verifyComplete()
    }
}
