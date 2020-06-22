package ru.ovi.testapp.domain.transactions

import ru.ovi.testapp.domain.common.ContentModel

data class TransactionListModel(
    val transactions: List<TransactionModel>,
    val average: Double?,
    val total: Double
) : ContentModel {
    override fun isEmpty(): Boolean = transactions.isEmpty()
}
