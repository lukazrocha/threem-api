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

    @Query(
        "SELECT SUM(amount) AS total_amount\n" +
            "FROM expenses e \n" +
            "WHERE date_part('year', e.\"date\") = date_part('year', cast(:dateReceived as DATE))\n" +
            "and date_part('month', e.\"date\") = date_part('month', cast(:dateReceived as DATE))",
        nativeQuery = true,
    )
    fun sumAllMonthExpenses(dateReceived: String): Double
}
