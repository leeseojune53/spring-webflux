package io.github.leeseojune53.springwebflux.domain.ballot.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class BallotRouter {

    @Bean
    fun ballotBaseRouter(ballotHandler: BallotHandler) = router {
        "/ballots".nest {
            POST(ballotHandler::postBallot)
        }
    }

}