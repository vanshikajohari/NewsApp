package com.example.mynews.ui.db


import com.example.mynews.ui.models.Article
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Delete
import androidx.room.Query



@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertArticle(article: Article) : Long

    @Query("SELECT * FROM articles")
    fun getAllArticles(): List<Article>

    @Delete
    fun deleteArticle(article: Article) : Int
}
