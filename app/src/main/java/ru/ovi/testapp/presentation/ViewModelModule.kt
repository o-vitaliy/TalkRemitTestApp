package ru.ovi.testapp.presentation

import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.testapp.presentation.auth.login.LoginViewModel
import ru.ovi.testapp.presentation.main.transactions.TransactionsViewModel
import ru.ovi.testapp.presentation.splash.SplashViewModel

val viewModelModule = Kodein.Module(name = "viewModelModule") {
    bind<ViewModelProvider.Factory>() with singleton {
        KodeinViewModelFactory(kodein)
    }

    bind<SplashViewModel>() with singleton { SplashViewModel(instance()) }
    bind<LoginViewModel>() with singleton { LoginViewModel(instance(), instance()) }
    bind<TransactionsViewModel>() with singleton { TransactionsViewModel(instance(), instance()) }
}
