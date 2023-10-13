package com.example.newsfeedapp.data.repository.datasourceImpl

import com.example.newsfeedapp.data.api.NewsAPIService
import com.example.newsfeedapp.data.model.APIResponse
import com.example.newsfeedapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
    private val country: String,
    private val page: Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }
}