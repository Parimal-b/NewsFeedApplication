package com.example.newsfeedapp.domain.usecase

import com.example.newsfeedapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {
}