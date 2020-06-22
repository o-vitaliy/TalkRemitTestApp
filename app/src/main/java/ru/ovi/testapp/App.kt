package ru.ovi.testapp

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import ru.ovi.testapp.data.di.apiModule
import ru.ovi.testapp.data.di.dataModule
import ru.ovi.testapp.presentation.viewModelModule
import ru.ovi.testapp.data.di.repositoryModule
import timber.log.Timber

class App : Application() , KodeinAware {

    override val kodein by Kodein.lazy {
        import(androidXModule(this@App))
        import(apiModule)
        import(dataModule)
        import(repositoryModule)
        import(viewModelModule)
    }


    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        AndroidThreeTen.init(this)
    }

}