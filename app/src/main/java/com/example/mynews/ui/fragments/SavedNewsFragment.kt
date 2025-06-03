package com.example.mynews.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynews.R
import com.example.mynews.databinding.FragmentBreakingNewsBinding
import com.example.mynews.databinding.FragmentSavedNewsBinding
import com.example.mynews.ui.NewsActivity
import com.example.mynews.ui.NewsViewModel
import com.example.mynews.ui.adapters.NewsAdapter

class SavedNewsFragment :Fragment(R.layout.fragment_saved_news){
lateinit var viewModel:NewsViewModel
    private var _binding: FragmentSavedNewsBinding? = null
    private val binding get() = _binding!!
    lateinit var newsAdapter : NewsAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as NewsActivity).viewModel
        _binding = FragmentSavedNewsBinding.bind(view)
        newsAdapter = NewsAdapter()
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable(
                    "article",
                    it
                )
                putString(
                    "prev",
                    "Saved"
                )
            }
            findNavController().navigate(
                R.id.action_savedNewsFragment_to_articleFragment,
                bundle
            )
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvSavedNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}