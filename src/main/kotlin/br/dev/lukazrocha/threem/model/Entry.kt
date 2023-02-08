package br.dev.lukazrocha.threem.model

import java.time.LocalDateTime
import java.time.temporal.TemporalAmount
import java.util.*

open class Entry(
    open var id: UUID? = null,
    open var date: LocalDateTime? = null,
    open var account: Account? = null,
    open var amount: Double? = null,
    open var note: String? = null,
)