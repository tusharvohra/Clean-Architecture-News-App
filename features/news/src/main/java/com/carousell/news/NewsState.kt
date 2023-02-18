package com.carousell.news

import com.carousell.domain.model.NewsArticle

data class NewsState(
    var isLoading: Boolean = false,
    var msg: String = "",
    var data: List<NewsArticle>? = null
)
