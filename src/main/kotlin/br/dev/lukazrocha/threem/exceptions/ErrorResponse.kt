package br.dev.lukazrocha.threem.exceptions

import com.fasterxml.jackson.annotation.JsonAlias

data class ErrorResponse(
    @JsonAlias("internal-code")
    val internalCode: String,
    val message: String,
    val status: String,
    @JsonAlias("status-code")
    val error: Int,
)
