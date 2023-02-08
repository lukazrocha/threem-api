package br.dev.lukazrocha.threem.model

import jakarta.persistence.*
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "incomes")
class Income : Entry() {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    override var id: UUID? = null

    @Column
    override var date: LocalDateTime? = null

    @ManyToOne
    override var account: Account? = null

    @Column
    override var amount: Double? = null

    @Column
    override var note: String? = null

    @ManyToOne
    var category: IncomeCategory? = null
}