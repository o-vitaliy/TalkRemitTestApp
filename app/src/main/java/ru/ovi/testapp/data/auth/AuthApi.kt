package ru.ovi.testapp.data.auth

import retrofit2.http.Body
import retrofit2.http.POST
import ru.ovi.testapp.data.api.Response
import ru.ovi.testapp.data.auth.request.LoginRequest
import ru.ovi.testapp.data.auth.response.LoginResponse

interface AuthApi {
    @POST("/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>
}