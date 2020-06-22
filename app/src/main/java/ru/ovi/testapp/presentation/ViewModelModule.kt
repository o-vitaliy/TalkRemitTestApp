package ru.ovi.testapp.presentation

import androidx.lifecycle.ViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton
import ru.ovi.testapp.presentation.auth.authViewModelModule

val viewModelModule = Kodein.Module(name = "viewModelModule") {
    bind<ViewModelProvider.Factory>() with singleton {
        KodeinViewModelFactory(kodein)
    }
    import(authViewModelModule)

    /*  bind<MainViewModel>() with singleton { MainViewModel(instance()) }*/

}
