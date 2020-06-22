package ru.ovi.testapp.data.api

import okhttp3.Interceptor
import okhttp3.Response
import ru.ovi.testapp.data.auth.datasource.AuthTokenDataSource

class AuthTokenInterceptor(
    private val authTokenDataSource: AuthTokenDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()
        authTokenDataSource.authToken?.let {
            builder.addHeader(AUTH_HEADER, it)
        }
        return chain.proceed(builder.build())
    }

    companion object {
        private const val AUTH_HEADER = "X-AUTH-TOKEN"
    }
}