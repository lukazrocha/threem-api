package br.dev.lukazrocha.threem.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "income_categories")
class IncomeCategory(): Category() {

    @get:Id
    @set:GeneratedValue(strategy = GenerationType.UUID)
    override var id: UUID?
        get() = super.id
        set(id) {
            super.id = id
        }

    override var name: String?
        get() = super.name
        set(value) {}
}
