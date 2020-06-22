package ru.ovi.testapp.presentation.common.form

class InputStringField(
    validator: InputFieldValidator<String>,
    validationCallback: ((IntArray) -> Unit)?,
    initialValue: String = ""
) : InputField<String>(initialValue, validator, validationCallback)
