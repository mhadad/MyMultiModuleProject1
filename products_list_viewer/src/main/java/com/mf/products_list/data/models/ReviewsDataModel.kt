package com.mf.products_list.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewsDataModel(val rating: Int, val comment: String, val date: String, val reviewerName: String, val reviewerEmail: String)
