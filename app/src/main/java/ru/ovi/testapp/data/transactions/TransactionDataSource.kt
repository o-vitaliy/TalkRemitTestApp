package ru.ovi.testapp.data.transactions

import ru.ovi.testapp.data.transactions.response.TransactionsResponse

interface TransactionDataSource {
    suspend fun getTransactions(): TransactionsResponse
}
