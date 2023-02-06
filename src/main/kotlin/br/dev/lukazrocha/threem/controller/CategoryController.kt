package br.dev.lukazrocha.threem.controller

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

    @GetMapping
    fun getAllCategories(): List<Category> {
        return service.getAll()
    }

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable("id") id: UUID): Category {
        return service.findCategoryById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCategory(@RequestBody category: Category): Category {
        return service.saveCategory(category)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCategory(@PathVariable("id") id: UUID) {
        service.deleteCategory(id)
    }

}