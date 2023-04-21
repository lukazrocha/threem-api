package br.dev.lukazrocha.threem.model

import com.fasterxml.jackson.annotation.JsonIgnore
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

    @OneToMany(mappedBy = "account")
    @JsonIgnore
    var incomes: MutableList<Income>? = null,

    @OneToMany()
    @JsonIgnore
    var expenses: MutableList<Expense>? = null,

    private var active: Boolean = true,
) {

    fun inactivate() {
        this.active = false
        this.incomes?.forEach { it.inactivate() }
        this.expenses?.forEach { it.inactivate() }
    }

    fun activate() {
        this.active = true
        this.incomes?.forEach { it.activate() }
        this.expenses?.forEach { it.activate() }
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
