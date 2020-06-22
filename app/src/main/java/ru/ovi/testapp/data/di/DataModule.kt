package ru.ovi.testapp.data.di

import android.content.SharedPreferences
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import ru.ovi.testapp.data.auth.datasource.AuthDataSource
import ru.ovi.testapp.data.auth.datasource.AuthRemoteDataSource
import ru.ovi.testapp.data.auth.datasource.AuthTokenDataSource
import ru.ovi.testapp.data.auth.datasource.AuthTokenPrefsDataSource
import ru.ovi.testapp.data.transactions.TransactionDataSource
import ru.ovi.testapp.data.transactions.TransactionRemoteDataSource
import ru.ovi.testapp.domain.common.ResourceProvider
import ru.perevozka24.perevozka24.data.prefs.PrefsSourceFactory

val dataModule = Kodein.Module("data") {
    bind<SharedPreferences>() with singleton {
        PrefsSourceFactory.create(instance())
    }

    bind<ResourceProvider>() with singleton {
        ResourceProvider(instance())
    }

    bind<AuthTokenDataSource>() with singleton {
        AuthTokenPrefsDataSource(instance())
    }

    bind<AuthDataSource>() with singleton {
        AuthRemoteDataSource(instance())
    }
    bind<TransactionDataSource>() with singleton {
        TransactionRemoteDataSource(instance())
    }
}
