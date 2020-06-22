package ru.ovi.testapp.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import ru.ovi.testapp.domain.auth.AuthRepository

class SplashViewModel(private val authRepository: AuthRepository) : ViewModel() {

    val authorized = liveData { emit(authRepository.isAuthorized()) }
}
