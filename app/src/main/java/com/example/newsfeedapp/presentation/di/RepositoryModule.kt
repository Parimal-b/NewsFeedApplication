package com.example.newsfeedapp.presentation.di

import com.example.newsfeedapp.data.repository.NewsRepositoryImpl
import com.example.newsfeedapp.data.repository.datasource.NewsLocalDataSource
import com.example.newsfeedapp.data.repository.datasource.NewsRemoteDataSource
import com.example.newsfeedapp.domain.repository.NewsRepository
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
        newsRemoteDataSource: NewsRemoteDataSource,
        newsLocalDataSource: NewsLocalDataSource
    ):NewsRepository{
        return NewsRepositoryImpl(newsRemoteDataSource, newsLocalDataSource )
    }
}