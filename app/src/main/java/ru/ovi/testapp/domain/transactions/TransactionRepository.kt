package ru.ovi.testapp.domain.transactions

interface TransactionRepository {

    suspend fun getTransactions(): TransactionListModel
}
