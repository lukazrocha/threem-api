package br.dev.lukazrocha.threem.model

import jakarta.persistence.*
import org.hibernate.Hibernate
import java.util.*

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    var name: String? = null,

    @OneToMany
    var incomes: MutableList<Income>? = null,

    @OneToMany
    var expenses: MutableList<Expense>? = null,

    var active: Boolean = true,
) {

    fun inactivateAccount() {
        this.active = false
        this.incomes?.forEach { it.active = false }
        this.expenses?.forEach { it.active = false }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Account

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , incomes = $incomes, expenses = $expenses , active = $active )"
    }
}