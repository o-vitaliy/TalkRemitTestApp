package ru.ovi.testapp.presentation.common.form

import ru.ovi.testapp.R

class EmptyFieldValidator : InputFieldValidator<String> {

    override fun validate(input: String): Int? {
        if (input.isEmpty()) {
            return R.string.form_validate_required
        }
        return null
    }
}
