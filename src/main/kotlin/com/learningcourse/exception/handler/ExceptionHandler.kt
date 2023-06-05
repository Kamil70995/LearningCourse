package com.learningcourse.exception.handler

import com.learningcourse.exception.BaseBusinessException
import com.learningcourse.exception.InternalErrorException
import com.learningcourse.exception.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExceptionHandler {

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalErrorException::class)
    protected fun handleInternalErrorException(e: InternalErrorException): ResponseEntity<String> {
        return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e.message)
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseBusinessException::class)
    protected fun handleBusinessException(e: BaseBusinessException): ResponseEntity<String> {
        return createResponseEntity(HttpStatus.BAD_REQUEST, e.message)
    }

    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun exceptionHandler(e: Exception): ResponseEntity<ErrorDto> {
        val body = ErrorDto(getErrorCode(HttpStatus.INTERNAL_SERVER_ERROR), e.message)
        return createResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, body)
    }

    private fun <T> createResponseEntity(status: HttpStatus, body: T): ResponseEntity<T> {
        return ResponseEntity.status(status)
            .header("Content-Type", "application/json")
            .body(body)
    }

    private fun getErrorCode(httpStatus: HttpStatus): String {
        return httpStatus.value().toString()
    }
}