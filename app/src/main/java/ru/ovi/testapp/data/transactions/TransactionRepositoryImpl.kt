package ru.ovi.testapp.data.transactions

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ovi.testapp.domain.transactions.TransactionListModel
import ru.ovi.testapp.domain.transactions.TransactionModel
import ru.ovi.testapp.domain.transactions.TransactionRepository

class TransactionRepositoryImpl(
    private val transactionDataSource: TransactionDataSource
) : TransactionRepository {
    override suspend fun getTransactions(): TransactionListModel {
        return withContext(Dispatchers.IO) {
            val transactions = transactionDataSource.getTransactions().transactions
            val average = TransactionsHelper.calculateAverage(transactions)
            val total = TransactionsHelper.calculateTotal(transactions)
            TransactionListModel(transactions.map {
                TransactionModel(it.destAmount, it.date)
            }, average, total)
        }
    }
}
