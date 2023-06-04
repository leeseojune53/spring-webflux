package io.github.leeseojune53.springwebflux.config.exception

import org.slf4j.LoggerFactory
import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest

@Component
class FluxErrorAttribute: DefaultErrorAttributes() {

    private val logger = LoggerFactory.getLogger(this::class.java)

    companion object {
        private const val INTERNAL_SERVER_ERROR_MESSAGE = "서버 내부 에러가 발생했습니다. 관리자에게 문의하세요."
    }

    override fun getErrorAttributes(request: ServerRequest?, options: ErrorAttributeOptions?): MutableMap<String, Any> {
        val errorAttributes = super.getErrorAttributes(request, options)
        val throwable = getError(request)
        if (throwable is FluxException) {
            errorAttributes["status"] = 400
            errorAttributes["message"] = throwable.message
            errorAttributes["error"] = throwable.code.getCode()
        } else {
            errorAttributes["status"] = 500
            errorAttributes["message"] = INTERNAL_SERVER_ERROR_MESSAGE
            logger.error("Internal Server Error : {} ", throwable.message)
            logger.error("stack trace : {}", throwable.fillInStackTrace().stackTrace)
        }
        return errorAttributes
    }

}