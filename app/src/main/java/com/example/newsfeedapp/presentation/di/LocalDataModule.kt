package com.example.newsfeedapp.presentation.di

import com.example.newsfeedapp.data.db.ArticleDao
import com.example.newsfeedapp.data.repository.datasource.NewsLocalDataSource
import com.example.newsfeedapp.data.repository.datasourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataModule {
    @Singleton
    @Provides
    fun provideLocalDataSource(articleDao: ArticleDao): NewsLocalDataSource{
        return NewsLocalDataSourceImpl(articleDao)
    }
}