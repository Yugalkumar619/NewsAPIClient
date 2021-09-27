package com.yugal.newsapiclient.data.repository.dataSource

import com.yugal.newsapiclient.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines():Response<APIResponse>
}