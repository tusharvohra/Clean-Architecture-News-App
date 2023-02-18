package com.carousell.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewsArticle(
    var banner_url: String?,
    var description: String? = "",
    var rank: Int?,
    var time_created: Int?,
    var title: String?
) : Parcelable
