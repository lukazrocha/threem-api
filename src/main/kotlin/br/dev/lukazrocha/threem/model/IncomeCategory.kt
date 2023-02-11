package br.dev.lukazrocha.threem.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "income_categories")
class IncomeCategory : Category() {

    override var name: String?
        get() = super.name
        set(value) {
            super.name = value
        }
}
