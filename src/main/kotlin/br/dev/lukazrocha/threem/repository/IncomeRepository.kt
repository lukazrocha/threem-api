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
}
