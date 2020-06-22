package ru.ovi.testapp.domain.auth

interface AuthRepository {

    suspend fun isAuthorized():Boolean

    suspend fun login(params: LoginRequestParams)
}