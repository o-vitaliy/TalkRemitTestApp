package ru.ovi.testapp.data.auth.datasource

interface AuthTokenDataSource {

    var authToken: String?

    fun clear()
}
