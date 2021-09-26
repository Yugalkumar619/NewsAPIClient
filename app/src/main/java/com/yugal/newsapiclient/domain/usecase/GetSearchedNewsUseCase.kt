package com.yugal.newsapiclient.domain.usecase

import com.yugal.newsapiclient.data.model.APIResponse
import com.yugal.newsapiclient.data.util.Resource
import com.yugal.newsapiclient.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<APIResponse>{
        return newsRepository.getSearchedNews(searchQuery)
    }
}