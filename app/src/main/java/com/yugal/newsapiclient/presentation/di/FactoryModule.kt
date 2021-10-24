package com.yugal.newsapiclient.presentation.di

import android.app.Application
import com.yugal.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.yugal.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.yugal.newsapiclient.domain.usecase.SaveNewsUseCase
import com.yugal.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
      application: Application,
      getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
      getSearchedNewsUseCase: GetSearchedNewsUseCase,
      saveNewsUseCase: SaveNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase
        )
    }
}