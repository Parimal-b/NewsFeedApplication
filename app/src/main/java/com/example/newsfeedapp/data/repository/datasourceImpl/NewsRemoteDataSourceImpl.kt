package com.example.newsfeedapp.data.repository.datasourceImpl

import com.example.newsfeedapp.data.api.NewsAPIService
import com.example.newsfeedapp.data.model.APIResponse
import com.example.newsfeedapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
    private val newsAPIService: NewsAPIService,
) : NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String, page: Int): Response<APIResponse> {
        return newsAPIService.getTopHeadlines(country, page)
    }

}