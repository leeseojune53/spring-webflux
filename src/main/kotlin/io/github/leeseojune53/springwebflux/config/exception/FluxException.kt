package io.github.leeseojune53.springwebflux.config.exception

class FluxException(
    val code: ExceptionCode,
    override val message: String
) : RuntimeException() {}