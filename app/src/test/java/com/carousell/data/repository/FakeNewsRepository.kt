package com.carousell.data.repository

import com.carousell.domain.model.NewsArticle
import com.carousell.domain.repository.NewsRepository

class FakeNewsRepository : NewsRepository {

    private val newsArticleList = mutableListOf(
        NewsArticle(
            banner_url = null,
            description = null,
            rank = 2,
            time_created = 1532853058,
            title = null
        ),
        NewsArticle(
            banner_url = null,
            description = null,
            rank = 5,
            time_created = 1532939458,
            title = null
        ),
        NewsArticle(
            banner_url = null,
            description = null,
            rank = 1,
            time_created = 1530322670,
            title = null
        ),
        NewsArticle(
            banner_url = null,
            description = null,
            rank = 1,
            time_created = 1519983341,
            title = null
        ),
        NewsArticle(
            banner_url = null,
            description = null,
            rank = 5,
            time_created = 1527672941,
            title = null
        ),
        NewsArticle(
            banner_url = null,
            description = null,
            rank = 7,
            time_created = 1527672941,
            title = null
        )
    )

    override suspend fun getNewsArticles(): List<NewsArticle> {
        return newsArticleList
    }
}