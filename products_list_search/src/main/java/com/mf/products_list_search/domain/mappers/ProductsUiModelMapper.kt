package com.mf.products_list_search.domain.mappers

import com.mf.products_list.data.models.MetaDataModel
import com.mf.products_list.data.models.ProductDataModel
import com.mf.products_list.data.models.ReviewsDataModel
import com.mf.products_list_search.domain.models.DimensionsUiModel
import com.mf.products_list_search.domain.models.MetaUiModel
import com.mf.products_list_search.domain.models.ProductUiModel
import com.mf.products_list_search.domain.models.ReviewsUiModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
//@Mapper
class ProductsUiModelMapper @Inject constructor() {
//    companion object {
//        val INSTANCE: ProductsUiModelMapper = Mappers.getMapper(ProductsUiModelMapper::class.java)
//    }
////    @Provides
//    fun toProductUiModelList( data: List<ProductDataModel>): List<ProductUiModel>
    fun toProductUiModelList( data: List<ProductDataModel>): List<ProductUiModel>{
        return data.map { ProductUiModel(it.id, it.title, it.description, it.category, it.price, it.discountPercentage, it.rating, it.stock, it.tags, it.brand, it.sku, it.weight,
            DimensionsUiModel(it.dimensions.width, it.dimensions.height, it.dimensions.depth), it.warrantyInformation, it.shippingInformation, it.availabilityStatus,
            toProductReviewsUiModel(it.reviews), it.returnPolicy, it.minimumOrderQuantity, it.images, it.thumbnail,
            toProductMetaUiModel(it.meta) ) }
    }
    fun toProductMetaUiModel(meta: MetaDataModel): MetaUiModel{
        return MetaUiModel(meta.createdAt, meta.updatedAt, meta.barcode, meta.qrCode)
    }
    fun toProductReviewsUiModel(data: List<ReviewsDataModel>): List<ReviewsUiModel>{
        return data.map {
            ReviewsUiModel(it.rating, it.comment, it.date, it.reviewerName, it.reviewerEmail)
        }
    }
}