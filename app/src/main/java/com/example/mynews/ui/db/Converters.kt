package com.example.mynews.ui.db

import androidx.room.TypeConverter
import com.example.mynews.ui.models.Source
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    private val gson = Gson()

    @TypeConverter
    fun fromSource(source: Source): String {
        return gson.toJson(source)
    }

    @TypeConverter
    fun toSource(source: String): Source {
        val type = object : TypeToken<Source>() {}.type
        return gson.fromJson(source, type)
    }
}
