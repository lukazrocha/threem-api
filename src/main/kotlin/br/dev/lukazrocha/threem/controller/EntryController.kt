package br.dev.lukazrocha.threem.controller

import br.dev.lukazrocha.threem.controller.dto.request.PostExpense
import br.dev.lukazrocha.threem.controller.dto.request.PostIncome
import br.dev.lukazrocha.threem.controller.dto.request.PutExpense
import br.dev.lukazrocha.threem.controller.dto.request.PutIncome
import br.dev.lukazrocha.threem.controller.dto.response.ExpenseResponseDto
import br.dev.lukazrocha.threem.controller.dto.response.IncomeResponseDto
import br.dev.lukazrocha.threem.model.Expense
import br.dev.lukazrocha.threem.model.Income
import br.dev.lukazrocha.threem.service.EntryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/entries")
class EntryController(
    private val entryService: EntryService,
) {

    // INCOMES
    @GetMapping("/incomes")
    fun getAllActiveIncomes(): List<Income> {
        return entryService.getAllActiveIncomes()
    }

    @GetMapping("/incomes/all")
    fun getAllIncomes(): List<Income> {
        return entryService.getAllIncomes()
    }

    @GetMapping("/incomes/{id}")
    fun getIncomeById(@PathVariable("id") id: UUID): Income {
        return entryService.getIncomeById(id)
    }

    @PostMapping("/incomes")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewIncome(@RequestBody income: PostIncome): IncomeResponseDto {
        return entryService.saveIncome(income)
    }

    @PutMapping("/incomes/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateIncome(@PathVariable("id") id: UUID, @RequestBody income: PutIncome): IncomeResponseDto {
        return entryService.updateIncome(id, income)
    }

    @DeleteMapping("/incomes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteIncome(@PathVariable("id") id: UUID) {
        entryService.deleteIncome(id)
    }

    // EXPENSES
    @GetMapping("/expenses")
    fun getAllActiveExpenses(): List<Expense> {
        return entryService.getAllActiveExpenses()
    }

    @GetMapping("/expenses/all")
    fun getAllExpenses(): List<Expense> {
        return entryService.getAllExpenses()
    }

    @GetMapping("/expenses/{id}")
    fun getExpenseById(@PathVariable("id") id: UUID): Expense {
        return entryService.getExpenseById(id)
    }

    @PostMapping("/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveNewExpense(@RequestBody expense: PostExpense): ExpenseResponseDto {
        return entryService.saveExpense(expense)
    }

    @PutMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateExpense(@PathVariable("id") id: UUID, @RequestBody expense: PutExpense): ExpenseResponseDto {
        return entryService.updateExpense(id, expense)
    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteExpense(@PathVariable("id") id: UUID) {
        entryService.deleteExpense(id)
    }
}
