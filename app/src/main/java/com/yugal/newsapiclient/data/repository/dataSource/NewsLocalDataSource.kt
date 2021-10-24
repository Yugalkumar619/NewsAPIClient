package com.yugal.newsapiclient.data.repository.dataSource

import com.yugal.newsapiclient.data.model.Article

interface NewsLocalDataSource {
    suspend fun saveArticleToDB(article: Article)
}