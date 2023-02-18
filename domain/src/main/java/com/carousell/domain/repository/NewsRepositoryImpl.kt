package com.carousell.domain.repository

import com.carousell.data.network.NewsApiService
import com.carousell.domain.model.NewsArticle
import kotlinx.coroutines.delay
import toDomainNewsArticle

class NewsRepositoryImpl(private val newsApiService: NewsApiService) : NewsRepository {
    override suspend fun getNewsArticles(): List<NewsArticle> {
        return newsApiService.getNewsArticles().map {
            it.toDomainNewsArticle()
        }
    }
}