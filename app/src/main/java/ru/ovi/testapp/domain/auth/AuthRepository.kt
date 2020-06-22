package ru.ovi.testapp.domain.auth

interface AuthRepository {

    suspend fun login(params: LoginRequestParams)
}