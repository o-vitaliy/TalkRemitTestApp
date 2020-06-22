package ru.ovi.testapp.presentation.main.transactions

import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_transaction.view.*
import org.threeten.bp.format.DateTimeFormatter
import ru.ovi.testapp.R
import ru.ovi.testapp.domain.transactions.TransactionModel
import ru.ovi.testapp.presentation.common.toPrice

data class TransactionItem(private val transaction: TransactionModel) : Item() {

    override fun getLayout(): Int = R.layout.item_transaction

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        with(viewHolder.itemView) {
            itemTransactionDate.text =
                transaction.date.format(DateTimeFormatter.ofPattern(DATE_FORMAT))
            itemTransactionAmount.text = transaction.destAmount.toPrice()
        }
    }

    companion object {
        private const val DATE_FORMAT = "yyyy-MM-dd HH:mm"
    }
}