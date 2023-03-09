package br.dev.lukazrocha.threem.controller.dto.request

import com.fasterxml.jackson.annotation.JsonAlias
import java.time.LocalDateTime
import java.util.*

data class PutIncome(

    val date: LocalDateTime?,

    @JsonAlias("account_id")
    val accountId: UUID,

    val amount: Double,

    val note: String? = "",

    @JsonAlias("category_id")
    val categoryId: UUID,
)
