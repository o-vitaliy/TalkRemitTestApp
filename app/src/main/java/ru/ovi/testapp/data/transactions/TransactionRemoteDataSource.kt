package ru.ovi.testapp.data.transactions

import ru.ovi.testapp.data.transactions.response.TransactionsResponse

class TransactionRemoteDataSource(
    private val transactionApi: TransactionApi
) : TransactionDataSource {
    override suspend fun getTransactions(): TransactionsResponse {
        return transactionApi.getTransactions().getData()
    }
}
