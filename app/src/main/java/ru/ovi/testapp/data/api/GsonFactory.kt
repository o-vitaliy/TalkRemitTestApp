package ru.ovi.testapp.data.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import org.threeten.bp.LocalDateTime
import org.threeten.bp.format.DateTimeFormatter

object GsonFactory {
    fun create(): Gson = GsonBuilder()
        .setLenient()
        .registerTypeAdapter(LocalDateTime::class.java, localDateTimeJsonDeserializer)
        .create()

    private val localDateTimeJsonDeserializer = JsonDeserializer<LocalDateTime> { json, _, _ ->
        LocalDateTime.parse(json.asString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
    }
}
