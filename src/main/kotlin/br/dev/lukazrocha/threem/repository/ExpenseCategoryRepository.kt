package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.ExpenseCategory
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ExpenseCategoryRepository : JpaRepository<ExpenseCategory, UUID>