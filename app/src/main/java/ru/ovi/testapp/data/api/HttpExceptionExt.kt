package ru.ovi.testapp.data.api

import com.google.gson.Gson
import retrofit2.HttpException

fun HttpException.getError(): String? {
    return response()?.errorBody()?.charStream()?.readText()?.let {
        val response = Gson().fromJson<Response<Any>>(it, Response::class.java)
        response.message
    }
}
