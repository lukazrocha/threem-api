package br.dev.lukazrocha.threem.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "accounts")
data class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID? = null,

    val name: String? = null,
)