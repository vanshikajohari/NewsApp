// File: com/example/mynews/models/NewsResponse.kt

package com.example.mynews.ui.models

import com.example.mynews.ui.models.Article

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
