package ru.ovi.testapp.data.transactions

import ru.ovi.testapp.data.entity.TransactionEntity

object TransactionsHelper {

    fun calculateTotal(list: List<TransactionEntity>): Double {
        return list.sumByDouble { it.destAmount }
    }

    fun calculateAverage(list: List<TransactionEntity>): Double? {
        return list.takeIf { it.isNotEmpty() }?.let {
            calculateTotal(it) / it.size
        }
    }
}