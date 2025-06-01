package com.example.mynews.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.mynews.R
import com.example.mynews.ui.NewsActivity
import com.example.mynews.ui.NewsViewModel


class ArticleFragment :Fragment(R.layout.fragment_article){
    lateinit var viewModel:NewsViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as NewsActivity).viewModel
    }
}