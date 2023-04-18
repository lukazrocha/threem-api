package br.dev.lukazrocha.threem.controller.dto.response

import java.util.UUID

data class AccountResponseDto(
    val id: UUID?,
    val name: String?,
    val incomes: List<IncomeResponseDto?>,
    val expenses: List<ExpenseResponseDto?>,
)
