package ru.ovi.testapp.presentation.common

import java.text.DecimalFormat

private val FORMATTER = DecimalFormat("#0.00")

fun Double.toPrice() = FORMATTER.format(this)
