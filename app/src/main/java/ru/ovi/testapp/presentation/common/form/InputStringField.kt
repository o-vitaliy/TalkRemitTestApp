package ru.ovi.testapp.presentation.common.form

class InputStringField(
    validator: InputFieldValidator<String>,
    validationCallback: ((Array<Int>) -> Unit)?,
    initialValue: String = ""
) : InputField<String>(initialValue, validator, validationCallback)

