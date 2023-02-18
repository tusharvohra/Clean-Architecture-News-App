package com.carousell.data.network

import com.carousell.data.model.NewsArticleDTO
import retrofit2.http.GET

interface NewsApiService {

    //https://storage.googleapis.com/carousell-interview-assets/android/carousell_news.json

    @GET("carousell_news.json")
    suspend fun getNewsArticles(): ArrayList<NewsArticleDTO>
}