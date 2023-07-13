package io.github.leeseojune53.springwebflux.domain.ballot.router

import io.github.leeseojune53.springwebflux.domain.ballot.service.BallotService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class BallotHandler(
    private val ballotService: BallotService
) {

    fun postBallot(serverRequest: ServerRequest): Mono<ServerResponse> {
        val result = serverRequest.bodyToMono(BallotRequest::class.java)
            .map { ballotService.postBallot(it.voteId, it.target) }
        return ok().contentType(MediaType.APPLICATION_JSON).body(result, String::class.java)
    }

    class BallotRequest(
        val voteId: String,
        val target: String
    )


}