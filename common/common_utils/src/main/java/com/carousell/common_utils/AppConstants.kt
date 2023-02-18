package com.carousell.common_utils

object AppConstants {
    const val BASE_URL = "https://storage.googleapis.com/carousell-interview-assets/android/"

    enum class SortingAction(action: String) {
        RECENT("recent"),
        POPULAR("popular"),
        TIME_CREATED("time_created")
    }

}