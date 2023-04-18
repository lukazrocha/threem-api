package br.dev.lukazrocha.threem.controller.dto.response

import java.time.LocalDateTime
import java.util.*

data class ExpenseResponseDto(
    val id: UUID?,

    val date: LocalDateTime?,

    val account: String?,

    val amount: Double?,

    val note: String? = "",

    val category: String?,
)
