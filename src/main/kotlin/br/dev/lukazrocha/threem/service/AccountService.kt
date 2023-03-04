package br.dev.lukazrocha.threem.service

import br.dev.lukazrocha.threem.controller.dto.request.PostAccount
import br.dev.lukazrocha.threem.controller.dto.request.PutAccount
import br.dev.lukazrocha.threem.exceptions.AccountNotFoundException
import br.dev.lukazrocha.threem.model.Account
import br.dev.lukazrocha.threem.repository.AccountRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountService(
    private val accountRepository: AccountRepository,
) {

    fun getAllActiveAccounts(): List<Account> {
        return accountRepository.findAllActives()
    }

    fun getAllAccounts(): List<Account> {
        return accountRepository.findAll()
    }

    fun getAccountById(id: UUID): Account {
        return accountRepository.findById(id)
            .orElseThrow { AccountNotFoundException("Account with id: $id Not Found") }
    }

    fun saveAccount(account: PostAccount): Account {
        val accountToSave = Account()
        accountToSave.name = account.name

        return accountRepository.save(accountToSave)
    }

    fun updateAccount(id: UUID, account: PutAccount): Account {
        val accountById: Account = getAccountById(id)

        accountById.name = account.name
        return accountRepository.save(accountById)
    }

    fun deleteAccount(id: UUID) {
        val accountById: Account = getAccountById(id)

        accountById.inactivateAccount()
        accountRepository.save(accountById)
    }
}