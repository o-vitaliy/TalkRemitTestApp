package ru.ovi.testapp.presentation.main.transactions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.ovi.testapp.domain.common.ResourceProvider
import ru.ovi.testapp.domain.common.Result
import ru.ovi.testapp.domain.transactions.TransactionListModel
import ru.ovi.testapp.domain.transactions.TransactionRepository
import ru.ovi.testapp.presentation.common.BaseViewModel

class TransactionsViewModel(
    private val transactionRepository: TransactionRepository,
    resourceProvider: ResourceProvider
) : BaseViewModel(resourceProvider) {

    val transactions: LiveData<Result<TransactionListModel>> = MutableLiveData()

    init {
        launch(transactions) {
            transactionRepository.getTransactions()
        }
    }
}