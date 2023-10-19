package com.example.newsfeedapp.presentation.di

import com.example.newsfeedapp.domain.repository.NewsRepository
import com.example.newsfeedapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsfeedapp.domain.usecase.GetSearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideNewsHeadLineUseCase(
        newsRepository: NewsRepository
    ): GetNewsHeadlinesUseCase {
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsCaseUseCase(
        newsRepository: NewsRepository
    ): GetSearchedNewsUseCase {
        return GetSearchedNewsUseCase(
            newsRepository
        )
    }
}