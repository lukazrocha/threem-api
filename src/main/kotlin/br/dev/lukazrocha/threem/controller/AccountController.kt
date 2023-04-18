package br.dev.lukazrocha.threem.controller

import br.dev.lukazrocha.threem.controller.dto.request.PostAccount
import br.dev.lukazrocha.threem.controller.dto.request.PutAccount
import br.dev.lukazrocha.threem.controller.dto.response.AccountResponseDto
import br.dev.lukazrocha.threem.model.Account
import br.dev.lukazrocha.threem.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/accounts")
class AccountController(
    private val accountService: AccountService,
) {

    @GetMapping()
    fun getAllActiveAccounts(): List<AccountResponseDto> {
        return accountService.getAllActiveAccounts()
    }

    @GetMapping("/all")
    fun getAllAccounts(): List<Account> {
        return accountService.getAllAccounts()
    }

    @GetMapping("/{id}")
    fun getAccountById(@PathVariable("id") id: UUID): Account {
        return accountService.getAccountById(id)
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewAccount(@RequestBody account: PostAccount): Account {
        return accountService.saveAccount(account)
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateAccount(@PathVariable("id") id: UUID, @RequestBody account: PutAccount): Account {
        return accountService.updateAccount(id, account)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteAccount(@PathVariable("id") id: UUID) {
        accountService.deleteAccount(id)
    }
}
