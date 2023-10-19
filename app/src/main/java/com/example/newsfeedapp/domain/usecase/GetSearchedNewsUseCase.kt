package com.example.newsfeedapp.domain.usecase

import com.example.newsfeedapp.data.model.APIResponse
import com.example.newsfeedapp.data.util.Resource
import com.example.newsfeedapp.domain.repository.NewsRepository

class GetSearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String, searchQuery: String, page:Int): Resource<APIResponse>{
        return newsRepository.getSearchedNews(country, searchQuery, page)
    }
}