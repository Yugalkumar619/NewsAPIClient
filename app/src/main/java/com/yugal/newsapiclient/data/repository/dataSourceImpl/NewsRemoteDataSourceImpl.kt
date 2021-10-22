package com.yugal.newsapiclient.data.repository.dataSourceImpl

import com.yugal.newsapiclient.data.api.NewsAPIService
import com.yugal.newsapiclient.data.model.APIResponse
import com.yugal.newsapiclient.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRemoteDataSourceImpl @Inject constructor(private val newsAPIService: NewsAPIService): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page : Int): Response<APIResponse>{
        return newsAPIService.getTopHeadlines(country, page)
    }

    override suspend fun getSearchedNews(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country,searchQuery,page)
    }

}

