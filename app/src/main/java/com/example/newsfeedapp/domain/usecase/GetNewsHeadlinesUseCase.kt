package com.example.newsfeedapp.domain.usecase

import com.example.newsfeedapp.data.model.APIResponse
import com.example.newsfeedapp.data.util.Resource
import com.example.newsfeedapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(country: String, page: Int): Resource<APIResponse> {
        return newsRepository.getNewsHeadlines(country, page)
    }
}