package br.dev.lukazrocha.threem.controller

import br.dev.lukazrocha.threem.controller.dto.request.PostIncome
import br.dev.lukazrocha.threem.controller.dto.request.PutIncome
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
    fun saveNewIncome(@RequestBody income: PostIncome): Income {
        return entryService.saveIncome(income)
    }

    @PutMapping("/incomes/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    fun updateIncome(@PathVariable("id") id: UUID, @RequestBody income: PutIncome): Income {
        return entryService.updateIncome(id, income)
    }

    @DeleteMapping("/incomes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteIncome(@PathVariable("id") id: UUID) {
        entryService.deleteIncome(id)
    }
}
