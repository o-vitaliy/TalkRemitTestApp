package ru.ovi.testapp.data.di

import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.testapp.data.auth.AuthRepositoryImpl
import ru.ovi.testapp.domain.auth.AuthRepository

val repositoryModule = Kodein.Module("repository") {
    bind<AuthRepository>() with singleton {
        AuthRepositoryImpl(instance(), instance())
    }
}
