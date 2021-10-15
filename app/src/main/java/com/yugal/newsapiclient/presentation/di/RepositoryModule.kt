package com.yugal.newsapiclient.presentation.di

import com.yugal.newsapiclient.data.api.NewsAPIService
import com.yugal.newsapiclient.data.repository.NewsRepositoryImpl
import com.yugal.newsapiclient.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import com.yugal.newsapiclient.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsRemoteDataSource: NewsRemoteDataSourceImpl
    ): NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource)
    }




}