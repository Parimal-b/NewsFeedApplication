package com.example.newsfeedapp.data.repository.datasourceImpl

import com.example.newsfeedapp.data.db.ArticleDao
import com.example.newsfeedapp.data.model.Article
import com.example.newsfeedapp.data.repository.datasource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articleDao: ArticleDao
): NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articleDao.getAllArticles()
    }
}