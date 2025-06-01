package com.example.mynews.ui.db


import com.example.mynews.models.Article
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Delete
import androidx.room.Query



@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<Article>

    @Delete
    suspend fun deleteArticle(article: Article)
}
