package com.example.mynews.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.mynews.R
import com.example.mynews.databinding.ActivityNewsBinding
import com.example.mynews.repository.NewsRepository
import com.example.mynews.ui.api.RetrofitInstance
import com.example.mynews.ui.db.ArticleDatabase

class NewsActivity : AppCompatActivity() {
     lateinit var viewModel: NewsViewModel
    private lateinit var binding: ActivityNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup NavController
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.newsNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Initialize Database & Repository
        val database = ArticleDatabase.getInstance(this)
        val newsRepository = NewsRepository(database, RetrofitInstance.api)

        // ViewModel
        val viewModelFactory = NewsViewModelProviderFactory(newsRepository)
        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]

        // Setup Bottom Navigation
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}
