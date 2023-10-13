package com.example.newsfeedapp.domain.usecase

import com.example.newsfeedapp.data.model.Article
import com.example.newsfeedapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.saveNews(article)
}