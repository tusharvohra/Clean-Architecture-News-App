package com.carousell.news.ui

import com.carousell.domain.model.NewsArticle

interface AdapterToActivityCallback {
    fun onItemClick(newsArticle: NewsArticle)
}