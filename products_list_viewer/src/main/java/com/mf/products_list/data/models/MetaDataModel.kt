package com.mf.products_list.data.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MetaDataModel(val createdAt: String,val updatedAt: String, val barcode: String, val qrCode: String)
