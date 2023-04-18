package br.dev.lukazrocha.threem.model

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "incomes")
class Income : Entry() {

    @Column
    override var date: LocalDateTime? = null

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    @JsonIgnore
    override var account: Account? = null

    @Column
    override var amount: Double? = null

    @Column
    override var note: String? = null

    @ManyToOne
    var category: IncomeCategory? = null

    private var active: Boolean = true

    fun inactivate() {
        this.active = false
    }

    fun activate() {
        this.active = true
    }
}
