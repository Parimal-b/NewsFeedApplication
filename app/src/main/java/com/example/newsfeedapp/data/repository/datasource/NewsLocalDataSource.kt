package com.example.newsfeedapp.data.repository.datasource

import com.example.newsfeedapp.data.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsLocalDataSource {

    suspend fun saveArticleToDB(article: Article)
    fun getSavedArticles(): Flow<List<Article>>

    suspend fun deleteArticlesFromDB(article: Article)
}