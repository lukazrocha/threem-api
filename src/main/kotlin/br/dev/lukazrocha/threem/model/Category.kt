package br.dev.lukazrocha.threem.model

import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.*

@MappedSuperclass
open class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    open var id: UUID? = null
    open var name: String? = null
}
