package ru.ovi.testapp.data.di

import android.content.SharedPreferences
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import org.kodein.di.weakReference
import ru.ovi.testapp.data.auth.datasource.AuthDataSource
import ru.ovi.testapp.data.auth.datasource.AuthRemoteDataSource
import ru.ovi.testapp.data.auth.datasource.AuthTokenDataSource
import ru.ovi.testapp.data.auth.datasource.AuthTokenPrefsDataSource
import ru.perevozka24.perevozka24.data.prefs.PrefsSourceFactory

val dataModule = Kodein.Module("data") {
    bind<SharedPreferences>() with singleton(ref = weakReference) {
        PrefsSourceFactory.create(instance())
    }
    bind<AuthTokenDataSource>() with singleton(ref = weakReference) {
        AuthTokenPrefsDataSource(instance())
    }

    bind<AuthDataSource>() with singleton(ref = weakReference) {
        AuthRemoteDataSource(instance())
    }
}
