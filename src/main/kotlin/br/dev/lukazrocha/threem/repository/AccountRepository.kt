package br.dev.lukazrocha.threem.repository

import br.dev.lukazrocha.threem.model.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : JpaRepository<Account, UUID> {
    @Query("SELECT account FROM Account account WHERE account.active = true")
    fun findAllActives(): List<Account>
}