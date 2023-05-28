package io.github.leeseojune53.springwebflux.domain.vote.service

import io.github.leeseojune53.springwebflux.domain.vote.Vote
import io.github.leeseojune53.springwebflux.domain.vote.enum.VoteStatus
import io.github.leeseojune53.springwebflux.domain.vote.repository.VoteRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito

@DisplayName("VoteService 테스트")
internal class VoteServiceTest {

    @Mock
    lateinit var voteRepository: VoteRepository

    @InjectMocks
    lateinit var sut: VoteService



    @DisplayName("투표 목록을 조회할 수 있다.")
    @Test
    fun 투표_목록_조회_성공() {
        //given
        val vote = Vote("1", VoteStatus.PREPARE)

        //when
        Mockito.`when`(voteRepository.getVoteList()).then { listOf(vote) }

        //then

        val resultVote = sut.getVoteList().get(0)

        assertThat(resultVote.id).isEqualTo(vote.id)
        assertThat(resultVote.status).isEqualTo(vote.status)
    }

    @DisplayName("투표 빈 목록을 조회할 수 있다.")
    @Test
    fun 투표_빈_목록() {
        //given
        //give nothing

        //when
        Mockito.`when`(voteRepository.getVoteList()).then { emptyList<Vote>() }

        //then

        assertThat(sut.getVoteList()).isEmpty()
    }

    @DisplayName("투표 상태를 조회할 수 있다.")
    @Test
    fun 투표_상태_조회_성공() {
        //given
        val vote = Vote("1", VoteStatus.PREPARE)

        //when
        Mockito.`when`(voteRepository.getVoteStatus(any())).then { vote.status }

        //then


        val resultStatus = sut.getVoteStatus(vote.id)

        assertThat(resultStatus).isEqualTo(vote.status)
    }

}