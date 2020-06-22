package ru.ovi.testapp.data.transactions

import org.junit.Assert.*
import org.junit.Test
import org.threeten.bp.LocalDateTime
import ru.ovi.testapp.data.entity.TransactionEntity

class TransactionsHelperTest {

    @Test
    fun testCalculateTotal_emptyList() {
        val result = TransactionsHelper.calculateTotal(emptyList())
        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun testCalculateTotal_singleItem() {
        val result = TransactionsHelper.calculateTotal(
            listOf(
                TransactionEntity(1.0, LocalDateTime.now())
            )
        )
        assertEquals(1.0, result, 0.0)
    }

    @Test
    fun testCalculateTotal_severalItems() {
        val result = TransactionsHelper.calculateTotal(
            listOf(
                TransactionEntity(1.0, LocalDateTime.now()),
                TransactionEntity(11.0, LocalDateTime.now())
            )
        )
        assertEquals(12.0, result, 0.0)
    }


    @Test
    fun testCalculateAverage_emptyList() {
        val result = TransactionsHelper.calculateAverage(emptyList())
        assertNull(result)
    }

    @Test
    fun testCalculateAverage_singleItem() {
        val result = TransactionsHelper.calculateAverage(
            listOf(
                TransactionEntity(1.0, LocalDateTime.now())
            )
        )
        assertNotNull(result)
        assertEquals(1.0, result!!, 0.0)
    }

    @Test
    fun testCalculateAverage_severalItems() {
        val result = TransactionsHelper.calculateAverage(
            listOf(
                TransactionEntity(1.0, LocalDateTime.now()),
                TransactionEntity(11.0, LocalDateTime.now())
            )
        )
        assertNotNull(result)
        assertEquals(6.0, result!!, 0.0)
    }


}
