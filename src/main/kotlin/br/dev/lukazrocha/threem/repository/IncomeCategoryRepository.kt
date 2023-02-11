package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.IncomeCategory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IncomeCategoryRepository : JpaRepository<IncomeCategory, UUID>