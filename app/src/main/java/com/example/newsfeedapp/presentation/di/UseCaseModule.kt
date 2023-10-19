package com.example.newsfeedapp.presentation.di

import com.example.newsfeedapp.domain.repository.NewsRepository
import com.example.newsfeedapp.domain.usecase.DeleteSavedNewsUseCase
import com.example.newsfeedapp.domain.usecase.GetNewsHeadlinesUseCase
import com.example.newsfeedapp.domain.usecase.GetSavedNewsUseCase
import com.example.newsfeedapp.domain.usecase.GetSearchedNewsUseCase
import com.example.newsfeedapp.domain.usecase.SaveNewsUseCase
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

    @Singleton
    @Provides
    fun provideSaveNewsCaseUseCase(
        newsRepository: NewsRepository
    ): SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSavedNewsCaseUseCase(
        newsRepository: NewsRepository
    ): GetSavedNewsUseCase{
        return GetSavedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideDeleteSavedNewsCaseUseCase(
        newsRepository: NewsRepository
    ): DeleteSavedNewsUseCase{
        return DeleteSavedNewsUseCase(newsRepository)
    }
}