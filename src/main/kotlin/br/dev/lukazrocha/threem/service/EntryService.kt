package br.dev.lukazrocha.threem.service

import br.dev.lukazrocha.threem.controller.dto.request.PostExpense
import br.dev.lukazrocha.threem.controller.dto.request.PostIncome
import br.dev.lukazrocha.threem.controller.dto.request.PutExpense
import br.dev.lukazrocha.threem.controller.dto.request.PutIncome
import br.dev.lukazrocha.threem.controller.dto.response.ExpenseResponseDto
import br.dev.lukazrocha.threem.controller.dto.response.IncomeResponseDto
import br.dev.lukazrocha.threem.exceptions.ExpenseNotFoundException
import br.dev.lukazrocha.threem.exceptions.IncomeNotFoundException
import br.dev.lukazrocha.threem.extensions.toResponseDto
import br.dev.lukazrocha.threem.model.Expense
import br.dev.lukazrocha.threem.model.Income
import br.dev.lukazrocha.threem.repository.ExpenseRepository
import br.dev.lukazrocha.threem.repository.IncomeRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class EntryService(
    private val incomeRepository: IncomeRepository,
    private val expenseRepository: ExpenseRepository,
    private val categoryService: CategoryService,
    private val accountService: AccountService,
) {
    // INCOMES
    fun getAllActiveIncomes(): List<Income> {
        return incomeRepository.findAllActiveIncomes()
    }

    fun getAllIncomes(): List<Income> {
        return incomeRepository.findAll()
    }

    fun getIncomeById(id: UUID): Income {
        return incomeRepository.findById(id).orElseThrow { IncomeNotFoundException("Income with id: $id not found") }
    }

    fun saveIncome(income: PostIncome): IncomeResponseDto {
        val incomeToSave = Income()

        incomeToSave.date = income.date
        incomeToSave.amount = income.amount
        incomeToSave.note = income.note
        incomeToSave.category = categoryService.findIncomeCategoryById(income.categoryId)
        incomeToSave.account = accountService.getAccountById(income.accountId)

        return incomeRepository.save(incomeToSave).toResponseDto()
    }

    fun updateIncome(id: UUID, income: PutIncome): IncomeResponseDto {
        val incomeToUpdate = getIncomeById(id)

        incomeToUpdate.updateFromPutIncome(income)

        return incomeRepository.save(incomeToUpdate).toResponseDto()
    }

    fun deleteIncome(id: UUID) {
        val incomeToDelete = getIncomeById(id)

        incomeToDelete.inactivate()

        incomeRepository.save(incomeToDelete)
    }

    fun getIncomeMonthTotal(date: String): Double {
        return incomeRepository.sumAllMonthIncomes(date)
    }

    // EXPENSES
    fun getAllActiveExpenses(): List<Expense> {
        return expenseRepository.findAllActiveExpenses()
    }

    fun getAllExpenses(): List<Expense> {
        return expenseRepository.findAll()
    }

    fun getExpenseById(id: UUID): Expense {
        return expenseRepository.findById(id).orElseThrow { ExpenseNotFoundException("Expense with id: $id not found") }
    }

    fun saveExpense(expense: PostExpense): ExpenseResponseDto {
        val expenseToSave = Expense()

        expenseToSave.date = expense.date
        expenseToSave.amount = expense.amount
        expenseToSave.note = expense.note
        expenseToSave.category = categoryService.findExpenseCategoryById(expense.categoryId)
        expenseToSave.account = accountService.getAccountById(expense.accountId)

        return expenseRepository.save(expenseToSave).toResponseDto()
    }

    fun updateExpense(id: UUID, expense: PutExpense): ExpenseResponseDto {
        val expenseToUpdate = getExpenseById(id)

        expenseToUpdate.updateFromPutExpense(expense)

        return expenseRepository.save(expenseToUpdate).toResponseDto()
    }

    fun deleteExpense(id: UUID) {
        val expenseToDelete = getExpenseById(id)

        expenseToDelete.inactivate()

        expenseRepository.save(expenseToDelete)
    }

    fun getExpenseMonthTotal(date: String): Double {
        return expenseRepository.sumAllMonthExpenses(date)
    }

    // EXTENSIONS
    fun Income.updateFromPutIncome(putIncome: PutIncome) {
        putIncome.date?.let { this.date = it }
        putIncome.amount.let { this.amount = it }
        putIncome.note.let { this.note = it }
        putIncome.categoryId?.let { this.category = categoryService.findIncomeCategoryById(it) }
        putIncome.accountId?.let { this.account = accountService.getAccountById(it) }
    }

    fun Expense.updateFromPutExpense(putExpense: PutExpense) {
        putExpense.date?.let { this.date = it }
        putExpense.amount.let { this.amount = it }
        putExpense.note.let { this.note = it }
        putExpense.categoryId?.let { this.category = categoryService.findExpenseCategoryById(it) }
        putExpense.accountId?.let { this.account = accountService.getAccountById(it) }
    }
}
