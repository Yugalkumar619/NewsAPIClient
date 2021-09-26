package com.yugal.newsapiclient.domain.usecase

import com.yugal.newsapiclient.data.model.Article
import com.yugal.newsapiclient.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {

    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}