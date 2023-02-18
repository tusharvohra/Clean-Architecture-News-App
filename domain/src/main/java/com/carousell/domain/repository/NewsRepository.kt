package com.carousell.domain.repository

import com.carousell.domain.model.NewsArticle

// defines rules on how we can expect data from the data layer to be given to the UI.
interface NewsRepository {
    suspend fun getNewsArticles(): List<NewsArticle>
}