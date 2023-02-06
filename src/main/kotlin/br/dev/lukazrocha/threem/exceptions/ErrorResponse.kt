package br.dev.lukazrocha.threem.exceptions

data class ErrorResponse(
    val internalCode: String,
    val message: String,
    val status: String,
    val error: Int,
)
