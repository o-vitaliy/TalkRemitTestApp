package ru.ovi.testapp.data.auth.datasource

import ru.ovi.testapp.data.auth.request.LoginRequest
import ru.ovi.testapp.data.auth.response.LoginResponse

interface AuthDataSource {
    suspend fun login(params: LoginRequest): LoginResponse
}