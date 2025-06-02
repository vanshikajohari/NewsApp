package com.example.mynews.repository


import com.example.mynews.ui.db.ArticleDatabase
import com.example.mynews.ui.models.Article
import com.example.mynews.ui.api.NewsAPI
import com.example.mynews.ui.api.RetrofitInstance
import retrofit2.Retrofit

class NewsRepository(
    private val db: ArticleDatabase,
) {
    // Call Retrofit API
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String , pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)


//    // Room database operations
//    suspend fun upsert(article: Article) = db.getArticleDao().upsertArticle(article)
//
//    fun getSavedNews() = db.getArticleDao().getAllArticles()
//
//    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
