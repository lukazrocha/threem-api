package br.dev.lukazrocha.threem.service

import br.dev.lukazrocha.threem.controller.dto.request.PostIncomeCategory
import br.dev.lukazrocha.threem.controller.dto.request.PutIncomeCategory
import br.dev.lukazrocha.threem.exceptions.CategoryNotFoundException
import br.dev.lukazrocha.threem.model.IncomeCategory
import br.dev.lukazrocha.threem.repository.ExpenseCategoryRepository
import br.dev.lukazrocha.threem.repository.IncomeCategoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(
    private val incomeCategoryRepository: IncomeCategoryRepository,
    private val expenseCategoryRepository: ExpenseCategoryRepository,
) {

    fun findIncomeCategoryById(id: UUID): IncomeCategory {
        return incomeCategoryRepository.findById(id).orElseThrow { CategoryNotFoundException("Category Not Found") }
    }

    fun getAllIncomeCategories(): List<IncomeCategory> {
        return incomeCategoryRepository.findAll()
    }

    fun saveIncomeCategory(category: PostIncomeCategory): IncomeCategory {
        var incomeCategory: IncomeCategory = IncomeCategory()

        incomeCategory.name = category.name
        return incomeCategoryRepository.save(incomeCategory)
    }

    fun updateIncomeCategory(id: UUID, category: PutIncomeCategory) {
        var categoryById: IncomeCategory = findIncomeCategoryById(id)

        categoryById.name = category.name

        incomeCategoryRepository.save(categoryById)
    }

    fun deleteIncomeCategory(id: UUID) {
        val category: IncomeCategory = findIncomeCategoryById(id)
        incomeCategoryRepository.delete(category)
    }
}