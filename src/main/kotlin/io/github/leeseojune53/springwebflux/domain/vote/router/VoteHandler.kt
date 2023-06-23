package io.github.leeseojune53.springwebflux.domain.vote.router

import io.github.leeseojune53.springwebflux.domain.vote.model.VoteElement
import io.github.leeseojune53.springwebflux.domain.vote.service.VoteService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class VoteHandler(
    private val voteService: VoteService
) {

    fun getVoteList(serverRequest: ServerRequest): Mono<ServerResponse> {
        val result = voteService.getVoteList()
        return ok().contentType(MediaType.APPLICATION_JSON).body(result, VoteElement::class.java)
    }

    fun getVoteStatus(serverRequest: ServerRequest): Mono<ServerResponse> {
        val voteId = serverRequest.pathVariable("voteId")
        val result = voteService.getVoteStatus(voteId)
        return ok().contentType(MediaType.APPLICATION_JSON).body(result, String::class.java)
    }
}
