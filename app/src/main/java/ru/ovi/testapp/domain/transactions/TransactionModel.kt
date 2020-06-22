package ru.ovi.testapp.domain.transactions

import org.threeten.bp.LocalDateTime

data class TransactionModel(
    val destAmount: Double,
    val date: LocalDateTime
)
