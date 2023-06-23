package io.github.leeseojune53.springwebflux.config.exception

enum class ExceptionCode {

    BAD_REQUEST;

    fun getCode(): String = this.toString()
}
