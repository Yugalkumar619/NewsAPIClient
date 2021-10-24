package com.yugal.newsapiclient.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yugal.newsapiclient.domain.usecase.GetNewsHeadlinesUseCase
import com.yugal.newsapiclient.domain.usecase.GetSearchedNewsUseCase
import com.yugal.newsapiclient.domain.usecase.SaveNewsUseCase
import javax.inject.Inject
import javax.inject.Singleton

class NewsViewModelFactory(
    private val app:Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
    private val getSearchedNewsUseCase: GetSearchedNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase
):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return  NewsViewModel(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase,
            saveNewsUseCase
        ) as T
    }
}