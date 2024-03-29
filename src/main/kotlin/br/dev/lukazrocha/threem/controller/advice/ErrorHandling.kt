package br.dev.lukazrocha.threem.controller.advice

import br.dev.lukazrocha.threem.exceptions.*
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
            "C-001",
            ex.message!!,
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value(),
        )
    }

    @ExceptionHandler(AccountNotFoundException::class)
    fun handleAccountNotFoundException(ex: Exception, httpServletResponse: HttpServletResponse): ErrorResponse {
        httpServletResponse.status = HttpStatus.NOT_FOUND.value()
        return ErrorResponse(
            "A-001",
            ex.message!!,
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value(),
        )
    }

    @ExceptionHandler(IncomeNotFoundException::class)
    fun handleIncomeNotFoundException(ex: Exception, httpServletResponse: HttpServletResponse): ErrorResponse {
        httpServletResponse.status = HttpStatus.NOT_FOUND.value()
        return ErrorResponse(
            "I-001",
            ex.message!!,
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value(),
        )
    }

    @ExceptionHandler(ExpenseNotFoundException::class)
    fun handleExpenseNotFoundException(ex: Exception, httpServletResponse: HttpServletResponse): ErrorResponse {
        httpServletResponse.status = HttpStatus.NOT_FOUND.value()
        return ErrorResponse(
            "E-001",
            ex.message!!,
            HttpStatus.NOT_FOUND.toString(),
            HttpStatus.NOT_FOUND.value(),
        )
    }
}
