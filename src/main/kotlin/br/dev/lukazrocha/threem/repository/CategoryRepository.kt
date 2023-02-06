package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.Category
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryRepository : JpaRepository<Category, UUID>