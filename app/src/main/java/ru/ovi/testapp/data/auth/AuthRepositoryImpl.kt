package ru.ovi.testapp.data.auth

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.ovi.testapp.data.auth.datasource.AuthDataSource
import ru.ovi.testapp.data.auth.datasource.AuthTokenDataSource
import ru.ovi.testapp.data.auth.request.LoginRequest
import ru.ovi.testapp.domain.auth.AuthRepository
import ru.ovi.testapp.domain.auth.LoginRequestParams

class AuthRepositoryImpl(
    private val authDataSource: AuthDataSource,
    private val authTokenDataSource: AuthTokenDataSource
) : AuthRepository {
    override suspend fun login(params: LoginRequestParams) {
        withContext(Dispatchers.IO) {
            val token = authDataSource.login(
                LoginRequest(
                    email = params.email, password = params.password
                )
            )
            authTokenDataSource.authToken = token.token.token
        }
    }

    override suspend fun isAuthorized(): Boolean = authTokenDataSource.authToken != null
}
