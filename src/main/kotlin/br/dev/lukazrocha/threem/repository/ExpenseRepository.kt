package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.Expense
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExpenseRepository : JpaRepository<Expense, UUID> {

    @Query("SELECT expense FROM Expense expense WHERE expense.active = true")
    fun findAllActiveExpenses(): List<Expense>
}
