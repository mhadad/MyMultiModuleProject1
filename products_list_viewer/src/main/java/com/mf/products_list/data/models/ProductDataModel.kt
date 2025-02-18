package com.mf.products_list.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "products")
@JsonClass(generateAdapter = true)
data class ProductDataModel(@PrimaryKey(autoGenerate = false) val id: Int, val title: String, val description: String, val category: String, val price: Double, val discountPercentage: Double, val rating: Double, val stock: Double, val tags: List<String>, val brand: String, val sku: String, val weight: Int, val dimensions: DimensionsDataModel, val warrantyInformation: String, val shippingInformation: String, val availabilityStatus: String, val reviews: List<ReviewsDataModel>, val returnPolicy: String, val minimumOrderQuantity: Int, val images: List<String>, val thumbnail: String, val meta: MetaDataModel) {
}