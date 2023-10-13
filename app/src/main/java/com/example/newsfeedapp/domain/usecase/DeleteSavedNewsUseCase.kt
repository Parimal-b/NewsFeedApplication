package com.example.newsfeedapp.domain.usecase

import com.example.newsfeedapp.data.model.Article
import com.example.newsfeedapp.domain.repository.NewsRepository

class DeleteSavedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}