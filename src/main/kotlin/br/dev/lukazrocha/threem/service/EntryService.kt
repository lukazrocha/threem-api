package br.dev.lukazrocha.threem.service

import br.dev.lukazrocha.threem.controller.dto.request.PostIncome
import br.dev.lukazrocha.threem.controller.dto.request.PutIncome
import br.dev.lukazrocha.threem.exceptions.IncomeNotFoundException
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

    fun saveIncome(income: PostIncome): Income {
        val incomeToSave = Income()

        incomeToSave.date = income.date
        incomeToSave.amount = income.amount
        incomeToSave.note = income.note
        incomeToSave.category = categoryService.findIncomeCategoryById(income.categoryId)
        incomeToSave.account = accountService.getAccountById(income.accountId)

        return incomeRepository.save(incomeToSave)
    }

    fun updateIncome(id: UUID, income: PutIncome): Income {
        val incomeToUpdate = getIncomeById(id)

        if (income.date != null) {
            incomeToUpdate.date = income.date
        }

        incomeToUpdate.amount = income.amount
        incomeToUpdate.note = income.note
        incomeToUpdate.category = categoryService.findIncomeCategoryById(income.categoryId)
        incomeToUpdate.account = accountService.getAccountById(income.accountId)

        return incomeRepository.save(incomeToUpdate)
    }

    fun deleteIncome(id: UUID) {
        val incomeToDelete = getIncomeById(id)

        incomeToDelete.inactivate()

        incomeRepository.save(incomeToDelete)
    }
}
