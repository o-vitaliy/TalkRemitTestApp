package ru.ovi.testapp.data.transactions

import retrofit2.http.POST
import ru.ovi.testapp.data.api.Response
import ru.ovi.testapp.data.transactions.response.TransactionsResponse

interface TransactionApi {
    @POST("/remit/transaction/list")
    suspend fun getTransactions(): Response<TransactionsResponse>
}