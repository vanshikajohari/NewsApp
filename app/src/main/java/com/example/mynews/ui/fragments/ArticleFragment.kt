package com.example.mynews.ui.fragments

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.mynews.R
import com.example.mynews.databinding.FragmentArticleBinding
import com.example.mynews.databinding.FragmentBreakingNewsBinding
import com.example.mynews.ui.NewsActivity
import com.example.mynews.ui.NewsViewModel
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.findNavController

class ArticleFragment :Fragment(R.layout.fragment_article){
    lateinit var viewModel:NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    private var _binding: FragmentArticleBinding? = null
    private val binding get() = _binding!!


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as NewsActivity).viewModel
        _binding = FragmentArticleBinding.bind(view)
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)

        }

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    when (args.prev) {
                        "breaking" -> findNavController().navigate(R.id.breakingNewsFragment)
                        "saved" -> findNavController().navigate(R.id.savedNewsFragment)
                        "search" -> findNavController().navigate(R.id.searchNewsFragment)
                        else -> findNavController().navigateUp()
                    }
                }
            }
        )




    }
}