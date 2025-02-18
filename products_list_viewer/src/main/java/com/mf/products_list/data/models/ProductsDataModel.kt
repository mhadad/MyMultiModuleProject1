package com.mf.products_list.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProductsDataModel(@Json(name = "products") val products: List<ProductDataModel>, @Json(name = "total") val total: Int, @Json(name = "skip") val skip: Int,@Json(name = "limit") val limit: Int)