// File: com/example/mynews/models/NewsResponse.kt

package com.example.mynews.models

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
