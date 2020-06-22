package ru.ovi.testapp.presentation.auth

import org.kodein.di.Kodein

val authViewModelModule = Kodein.Module(name = "authViewModelModule") {
//    bind<LoginViewModel>() with provider { LoginViewModel(instance(), instance()) }

}
