package ru.ovi.testapp.data.transactions.response

import ru.ovi.testapp.data.entity.TransactionEntity

data class TransactionsResponse(
    val transactions: List<TransactionEntity>
)
