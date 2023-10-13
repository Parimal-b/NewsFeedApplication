package com.example.newsfeedapp.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsfeedapp.domain.usecase.GetNewsHeadlinesUseCase

class NewsViewModelFactory(
    val app: Application,
    val getNewsHeadLinesUseCase: GetNewsHeadlinesUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            app,
            getNewsHeadLinesUseCase
        ) as T
    }
}