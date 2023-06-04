package io.github.leeseojune53.springwebflux.config.exception

import org.springframework.boot.web.error.ErrorAttributeOptions
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes
import org.springframework.web.reactive.function.server.ServerRequest

class FluxErrorAttribute: DefaultErrorAttributes() {

    override fun getErrorAttributes(request: ServerRequest?, options: ErrorAttributeOptions?): MutableMap<String, Any> {
        val errorAttributes = super.getErrorAttributes(request, options)
        val throwable = getError(request)
        if (throwable is FluxException) {
            errorAttributes["message"] = throwable.message
            errorAttributes["errorCode"] = throwable.code.getCode()
        }
        return errorAttributes
    }

}