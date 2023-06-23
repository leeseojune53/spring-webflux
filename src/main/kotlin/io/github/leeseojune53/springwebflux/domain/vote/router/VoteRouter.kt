package io.github.leeseojune53.springwebflux.domain.vote.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class VoteRouter {

    @Bean
    fun voteBaseRouter(voteHandler: VoteHandler) = router {
        "/votes".nest {
            GET("/", voteHandler::getVoteList)
            GET("/{voteId}/status", voteHandler::getVoteStatus)
        }
    }
}
