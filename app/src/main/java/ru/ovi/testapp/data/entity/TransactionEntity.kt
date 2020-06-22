package ru.ovi.testapp.data.entity

import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDateTime

data class TransactionEntity(
    @SerializedName("dest_amount") val destAmount: Double,
    @SerializedName("creation_date") val date: LocalDateTime
)
