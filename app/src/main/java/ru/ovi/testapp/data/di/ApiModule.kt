package ru.ovi.testapp.data.di

import com.google.gson.Gson
import okhttp3.Interceptor
import org.kodein.di.Kodein
import org.kodein.di.generic.*
import retrofit2.Retrofit
import ru.ovi.testapp.data.api.AuthTokenInterceptor
import ru.ovi.testapp.data.api.ContentTypeInterceptor
import ru.ovi.testapp.data.api.GsonFactory
import ru.ovi.testapp.data.api.RetrofitFactory
import ru.ovi.testapp.data.auth.AuthApi
import ru.ovi.testapp.data.transactions.TransactionApi

val apiModule = Kodein.Module("api") {
    bind() from setBinding<Interceptor>()

    bind<Interceptor>().inSet() with singleton { ContentTypeInterceptor() }
    bind<Interceptor>().inSet() with singleton { AuthTokenInterceptor(instance()) }

    bind<Gson>() with singleton { GsonFactory.create() }
    bind<Retrofit>() with singleton {
        RetrofitFactory.create(
            instance(),
            "https://test-api.talkremit.com",
            instance()
        )
    }
    bind<AuthApi>() with singleton { instance<Retrofit>().create(AuthApi::class.java) }
    bind<TransactionApi>() with singleton { instance<Retrofit>().create(TransactionApi::class.java) }
}
