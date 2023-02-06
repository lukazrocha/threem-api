package br.dev.lukazrocha.threem.controller.advice

import br.dev.lukazrocha.threem.exceptions.CategoryNotFoundException
import br.dev.lukazrocha.threem.exceptions.ErrorResponse
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandling {
    
    @ExceptionHandler(CategoryNotFoundException::class)
    fun handleCategoryNotFoundException(ex: Exception, httpServletResponse: HttpServletResponse): ErrorResponse {
        httpServletResponse.status = HttpStatus.NOT_FOUND.value()
        return ErrorResponse(
            "0001",
            ex.message!!,
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value()
        )
    }
}