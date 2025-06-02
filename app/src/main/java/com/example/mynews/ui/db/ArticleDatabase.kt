package com.example.mynews.ui.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters  // <-- Add this import
import com.example.mynews.ui.models.Article
import com.example.mynews.ui.db.Converters
@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)  // <-- Make sure your Converters class exists and is imported
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao

    companion object {
        @Volatile
        private var INSTANCE: ArticleDatabase? = null

        fun getInstance(context: Context): ArticleDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java,
                    "article_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
