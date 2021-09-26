package com.yugal.newsapiclient.domain.usecase

import com.yugal.newsapiclient.data.model.Article
import com.yugal.newsapiclient.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article)= newsRepository.saveNews(article)
}