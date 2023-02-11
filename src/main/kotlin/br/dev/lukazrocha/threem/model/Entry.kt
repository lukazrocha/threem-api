package br.dev.lukazrocha.threem.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@MappedSuperclass
open class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open var id: UUID? = null
    open var date: LocalDateTime? = null

    @ManyToOne
    open var account: Account? = null
    open var amount: Double? = null
    open var note: String? = null
}