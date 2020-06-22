package ru.ovi.testapp.data.api

class Response<T : Any>(
     val message: String?,
    private val code: Int,
    private val data: T?
) {
    fun getData(): T {
        if (code != SUCCESS_REQUEST) throw ApiException(message ?: code.toString())
        return checkNotNull(data)
    }

    companion object {
        private const val SUCCESS_REQUEST = 200
    }
}