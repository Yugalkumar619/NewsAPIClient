package com.yugal.newsapiclient.domain.usecase

import com.yugal.newsapiclient.data.model.APIResponse
import com.yugal.newsapiclient.data.util.Resource
import com.yugal.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country:String, searchQuery: String,page: Int): Resource<APIResponse>{
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}