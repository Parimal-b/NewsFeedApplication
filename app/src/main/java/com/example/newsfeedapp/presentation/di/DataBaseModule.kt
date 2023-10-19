package com.example.newsfeedapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.newsfeedapp.data.db.ArticleDao
import com.example.newsfeedapp.data.db.ArticleDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Singleton
    @Provides
    fun provideNewsDataBase(app:Application): ArticleDatabase{
        return Room.databaseBuilder(app, ArticleDatabase::class.java,"news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(articleDatabase: ArticleDatabase): ArticleDao{
        return articleDatabase.getArticleDAO()
    }
}