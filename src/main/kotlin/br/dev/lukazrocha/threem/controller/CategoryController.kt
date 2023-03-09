package br.dev.lukazrocha.threem.controller

import br.dev.lukazrocha.threem.controller.dto.request.PostExpenseCategory
import br.dev.lukazrocha.threem.controller.dto.request.PostIncomeCategory
import br.dev.lukazrocha.threem.controller.dto.request.PutExpenseCategory
import br.dev.lukazrocha.threem.controller.dto.request.PutIncomeCategory
import br.dev.lukazrocha.threem.model.Category
import br.dev.lukazrocha.threem.service.CategoryService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/categories")
class CategoryController(
    private val service: CategoryService,
) {

    // Incomes
    @GetMapping("/incomes")
    fun getAllIncomeCategories(): List<Category> {
        return service.getAllIncomeCategories()
    }

    @GetMapping("/incomes/{id}")
    fun getIncomeCategoryById(@PathVariable("id") id: UUID): Category {
        return service.findIncomeCategoryById(id)
    }

    @PostMapping("/incomes")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveIncomeCategory(@RequestBody category: PostIncomeCategory): Category {
        return service.saveIncomeCategory(category)
    }

    @PutMapping("/incomes/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateIncomeCategory(
        @PathVariable("id") id: UUID,
        @RequestBody category: PutIncomeCategory,
    ) {
        return service.updateIncomeCategory(id, category)
    }

    @DeleteMapping("/incomes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteIncomeCategory(@PathVariable("id") id: UUID) {
        service.deleteIncomeCategory(id)
    }

    // Expenses
    @GetMapping("/expenses")
    fun getAllExpenseCategories(): List<Category> {
        return service.getAllExpenseCategories()
    }

    @GetMapping("/expenses/{id}")
    fun getExpenseCategoryById(@PathVariable("id") id: UUID): Category {
        return service.findExpenseCategoryById(id)
    }

    @PostMapping("/expenses")
    @ResponseStatus(HttpStatus.CREATED)
    fun saveExpenseCategory(@RequestBody category: PostExpenseCategory): Category {
        return service.saveExpenseCategory(category)
    }

    @PutMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateExpenseCategory(
        @PathVariable("id") id: UUID,
        @RequestBody category: PutExpenseCategory,
    ) {
        return service.updateExpenseCategory(id, category)
    }

    @DeleteMapping("/expenses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteExpenseCategory(@PathVariable("id") id: UUID) {
        service.deleteExpenseCategory(id)
    }
}
