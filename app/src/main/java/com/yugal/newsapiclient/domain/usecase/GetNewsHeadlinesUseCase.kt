package com.yugal.newsapiclient.domain.usecase

import com.yugal.newsapiclient.data.model.APIResponse
import com.yugal.newsapiclient.data.util.Resource
import com.yugal.newsapiclient.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<APIResponse>{
        return newsRepository.getNewsHeadlines()
    }
}