package com.yugal.newsapiclient.data.repository.dataSourceImpl

import com.yugal.newsapiclient.data.db.ArticleDAO
import com.yugal.newsapiclient.data.model.Article
import com.yugal.newsapiclient.data.repository.dataSource.NewsLocalDataSource

class NewsLocalDataSourceImpl(
    private val articleDAO: ArticleDAO
) : NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDAO.insert(article)
    }
}