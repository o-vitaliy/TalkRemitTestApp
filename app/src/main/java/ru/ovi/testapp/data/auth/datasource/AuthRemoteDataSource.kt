package ru.ovi.testapp.data.auth.datasource

import ru.ovi.testapp.data.auth.AuthApi
import ru.ovi.testapp.data.auth.request.LoginRequest
import ru.ovi.testapp.data.auth.response.LoginResponse

class AuthRemoteDataSource(private val api: AuthApi) : AuthDataSource {
    override suspend fun login(params: LoginRequest): LoginResponse = api.login(params).getData()
}