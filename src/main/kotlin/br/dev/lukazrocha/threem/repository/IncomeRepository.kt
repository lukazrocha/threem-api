package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.Income
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IncomeRepository : JpaRepository<Income, UUID> {

    @Query("SELECT income FROM Income income WHERE income.active = true")
    fun findAllActiveIncomes(): List<Income>

    @Query(
        "SELECT SUM(amount) AS total_amount\n" +
            "FROM incomes i \n" +
            "WHERE date_part('year', i.\"date\") = date_part('year', cast(:dateReceived as DATE))\n" +
            "and date_part('month', i.\"date\") = date_part('month', cast(:dateReceived as DATE))",
        nativeQuery = true,
    )
    fun sumAllMonthIncomes(dateReceived: String): Double
}
