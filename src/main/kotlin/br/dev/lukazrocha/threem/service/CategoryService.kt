package br.dev.lukazrocha.threem.service

import br.dev.lukazrocha.threem.exceptions.CategoryNotFoundException
import br.dev.lukazrocha.threem.model.Category
import br.dev.lukazrocha.threem.repository.CategoryRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryService(private val categoryRepository: CategoryRepository) {

    fun findCategoryById(id: UUID): Category {
        return categoryRepository.findById(id).orElseThrow { CategoryNotFoundException("Category Not Found") }
    }

    fun getAll(): List<Category> {
        return categoryRepository.findAll()
    }

    fun saveCategory(category: Category): Category {
        return categoryRepository.save(category)
    }

    fun deleteCategory(id: UUID, category: Category) {
        var categoryById: Category = findCategoryById(id)

        categoryById.name = category.name

        categoryRepository.save(categoryById)
    }

    fun deleteCategory(id: UUID) {
        val category: Category = findCategoryById(id)
        categoryRepository.delete(category)
    }
}