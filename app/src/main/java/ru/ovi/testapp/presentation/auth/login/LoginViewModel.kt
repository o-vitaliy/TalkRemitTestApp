package ru.ovi.testapp.presentation.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.ovi.testapp.domain.auth.AuthRepository
import ru.ovi.testapp.domain.auth.LoginRequestParams
import ru.ovi.testapp.domain.common.ResourceProvider
import ru.ovi.testapp.domain.common.Result
import ru.ovi.testapp.domain.common.postValue
import ru.ovi.testapp.domain.common.setValue
import ru.ovi.testapp.presentation.common.BaseViewModel
import ru.ovi.testapp.presentation.common.form.EmailValidator
import ru.ovi.testapp.presentation.common.form.EmptyFieldValidator
import ru.ovi.testapp.presentation.common.form.InputStringField

class LoginViewModel(
    private val authRepository: AuthRepository,
    resourceProvider: ResourceProvider
) : BaseViewModel(resourceProvider) {

    val emailError: LiveData<String?> = MutableLiveData()
    private val emailField = MutableLiveData(
        InputStringField(
            EmailValidator(),
            { emailError.postValue(it.stringify()) }
        )
    )

    val passwordError: LiveData<String?> = MutableLiveData()
    private val passwordField = MutableLiveData(
        InputStringField(
            EmptyFieldValidator(),
            { passwordError.postValue(it.stringify()) }
        ))

    val login: LiveData<Result<Unit>> = MutableLiveData()

    fun emailChange(username: String) {
        emailField.value?.value = username
        emailError.setValue(null)
    }

    fun passwordChange(password: String) {
        passwordField.value?.value = password
        passwordError.setValue(null)
    }

    fun login() {
        val fields = arrayOf(emailField, passwordField)

        val isValid = fields.map {
            it.value?.validate()
            (it.value?.hasError ?: true).not()
        }
            .all { it }

        if (isValid) {
            launch(login) {
                val params = LoginRequestParams(
                    email = checkNotNull(emailField.value?.value),
                    password = checkNotNull(passwordField.value?.value)
                )
                authRepository.login(params)
            }
        }
    }

    private fun IntArray.stringify(): String? {
        return takeIf { size > 0 }?.joinToString("\n") { resourceProvider.getString(it) }
    }
}
