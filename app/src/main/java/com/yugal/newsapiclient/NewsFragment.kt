package com.yugal.newsapiclient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yugal.newsapiclient.databinding.FragmentNewsBinding
import com.yugal.newsapiclient.presentation.adapter.NewsAdapter
import com.yugal.newsapiclient.presentation.viewmodel.NewsViewModel
import dagger.hilt.EntryPoint

class NewsFragment : Fragment() {
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var fragmentNewsBinding: FragmentNewsBinding
    private var country = "us"
    private var page = 1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsBinding = FragmentNewsBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        newsAdapter = (activity as MainActivity).newsAdapter
        initRecyclerView()
        viewNewsList()
    }

    private fun viewNewsList() {
        viewModel.getNewsHeadLines(country, page)
        viewModel.newsHeadLines.observe(viewLifecycleOwner,{response->
            when(response){
                is com.yugal.newsapiclient.data.util.Resource.Success->{
                    hideProgressBar()
                    response.data?.let {
                        newsAdapter.differ.submitList(it.articles.toList())
                        val message = it.articles.toList()
                    }
                }
                is com.yugal.newsapiclient.data.util.Resource.Error->{
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }
                is com.yugal.newsapiclient.data.util.Resource.Loading->{
                    showProgressBar()
                }
            }
        })
    }

    private fun initRecyclerView(){
        //  newsAdapter = NewsAdapter()
        fragmentNewsBinding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }

    }


    private fun showProgressBar(){
        fragmentNewsBinding.progressBars.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        fragmentNewsBinding.progressBars.visibility = View.INVISIBLE
    }
}