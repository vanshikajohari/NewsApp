package com.example.mynews.repository

import com.example.mynews.ui.db.ArticleDatabase
import com.example.mynews.models.Article
import com.example.mynews.ui.api.NewsAPI

class NewsRepository(
    private val db: ArticleDatabase,
    private val api: NewsAPI
) {
    // Call Retrofit API
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        api.getBreakingNews(countryCode, pageNumber)

    // Room database operations
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
