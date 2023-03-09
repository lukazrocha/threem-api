package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.Expense
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ExpenseRepository : JpaRepository<Expense, UUID>
