package ru.ovi.testapp.presentation.common.form

interface InputFieldValidator<T> {

    /**
     * Validates input value and returns error if value is not valid
     */
    fun validate(input: T): Int?
}
