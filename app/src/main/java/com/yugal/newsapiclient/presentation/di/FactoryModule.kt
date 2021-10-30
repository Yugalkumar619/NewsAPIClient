package com.yugal.newsapiclient.presentation.di

import android.app.Application
import com.yugal.newsapiclient.domain.usecase.*
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
      saveNewsUseCase: SaveNewsUseCase,
      getSaveNewsUseCase: GetSavedNewsUseCase,
      deleteSavedNewsUseCase: DeleteSavedNewsUseCase
    ):NewsViewModelFactory{
        return NewsViewModelFactory(
            application,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase,
            getSaveNewsUseCase,
            deleteSavedNewsUseCase
        )
    }
}