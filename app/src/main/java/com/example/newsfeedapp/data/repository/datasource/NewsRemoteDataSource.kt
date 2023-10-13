package com.example.newsfeedapp.data.repository.datasource

import com.example.newsfeedapp.data.model.APIResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadlines(): Response<APIResponse>
}