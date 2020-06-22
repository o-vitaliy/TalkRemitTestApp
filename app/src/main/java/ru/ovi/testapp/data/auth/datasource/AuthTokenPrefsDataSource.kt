package ru.ovi.testapp.data.auth.datasource

import android.content.SharedPreferences
import ru.ovi.testapp.data.prefs.prefString

class AuthTokenPrefsDataSource constructor(preferences: SharedPreferences) : AuthTokenDataSource {

    override var authToken: String? by prefString(preferences, AUTH_TOKEN)

    override fun clear() {
        authToken = null
    }

    companion object {
        const val AUTH_TOKEN = "auth_token"
    }
}
