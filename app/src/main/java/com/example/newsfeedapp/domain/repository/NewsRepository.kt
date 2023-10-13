package com.example.newsfeedapp.domain.repository

import com.example.newsfeedapp.data.model.APIResponse
import com.example.newsfeedapp.data.model.Article
import com.example.newsfeedapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    // Two functions for the network communication.
    suspend fun getNewsHeadlines(): Resource<APIResponse>
    suspend fun getSearchedNews(searchQuery: String): Resource<APIResponse>

    //Functions related to the Local DataBase
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>
}