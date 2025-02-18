package com.mf.products_list_search.domain.models

import com.mf.products_list.data.models.MetaDataModel
import com.mf.products_list.data.models.ReviewsDataModel

class ProductUiModel(val id: Int?, val title: String?, val description: String?, val category: String?, val price: Double?, val discountPercentage: Double?, val rating: Double?, val stock: Double?, val tags: List<String>?, val brand: String?, val sku: String?, val weight: Int?, val dimensions: DimensionsUiModel?, val warrantyInformation: String?, val shippingInformation: String?, val availabilityStatus: String?, val reviews: List<ReviewsUiModel>?, val returnPolicy: String?, val minimumOrderQuantity: Int?, val images: List<String>?, val thumbnail: String?, val meta: MetaUiModel?) {
}