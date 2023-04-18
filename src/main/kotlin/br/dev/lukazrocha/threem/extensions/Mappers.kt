package br.dev.lukazrocha.threem.extensions

import br.dev.lukazrocha.threem.controller.dto.response.AccountResponseDto
import br.dev.lukazrocha.threem.controller.dto.response.ExpenseResponseDto
import br.dev.lukazrocha.threem.controller.dto.response.IncomeResponseDto
import br.dev.lukazrocha.threem.model.Account
import br.dev.lukazrocha.threem.model.Expense
import br.dev.lukazrocha.threem.model.Income

fun Income.toResponseDto(): IncomeResponseDto {
    return IncomeResponseDto(
        this.id,
        this.date,
        this.account?.name,
        this.amount,
        this.note,
        this.category?.name,
    )
}

fun Expense.toResponseDto(): ExpenseResponseDto {
    return ExpenseResponseDto(
        this.id,
        this.date,
        this.account?.name,
        this.amount,
        this.note,
        this.category?.name,
    )
}

fun Account.toResponseDto(): AccountResponseDto {
    return AccountResponseDto(
        this.id,
        this.name,
        this.incomes?.map { it.toResponseDto() } ?: listOf(),
        this.expenses?.map { it.toResponseDto() } ?: listOf(),
    )
}
