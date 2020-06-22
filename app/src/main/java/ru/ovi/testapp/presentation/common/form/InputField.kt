package ru.ovi.testapp.presentation.common.form

open class InputField<T>(
    initialValue: T,
    private val validators: List<InputFieldValidator<T>>,
    private val validationCallback: ((Array<Int>) -> Unit)?
) {
    constructor(
        initialValue: T,
        validator: InputFieldValidator<T>,
        validationCallback: ((Array<Int>) -> Unit)? = null
    ) : this(initialValue, listOf(validator), validationCallback)

    var value: T = initialValue

    private var _errors = emptyArray<Int>()

    val hasError: Boolean
        get() = _errors.isNotEmpty()

    fun validate() {
        _errors = validators.mapNotNull { it.validate(value) }.toTypedArray()
        validationCallback?.invoke(_errors)
    }
}
