package io.github.leeseojune53.springwebflux.domain.user.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class UserRouter {

    @Bean
    fun userBaseRouter(userHandler: UserHandler) = router {
        "/users".nest {
            POST("/register", userHandler::registerUser)
        }
    }

}