package br.dev.lukazrocha.threem.model

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "expenses")
class Expense : Entry() {

    @Column
    override var date: LocalDateTime? = null

    @ManyToOne
    override var account: Account? = null

    @Column
    override var amount: Double? = null

    @Column
    override var note: String? = null

    @ManyToOne
    var category: ExpenseCategory? = null
}