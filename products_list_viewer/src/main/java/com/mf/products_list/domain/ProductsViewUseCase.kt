package com.mf.products_list.domain

import android.util.Log
import com.mf.products_list.data.models.DataRequestError
import com.mf.products_list.data.models.DataRequestState
import com.mf.products_list.data.models.ProductsDataModel
import com.mf.products_list.data.repos.RemoteProductsRepo
import com.mf.products_list.domain.mappers.ProductsUiModelMapper
import com.mf.products_list.domain.models.DataSuccess
import com.mf.products_list.domain.models.ProductUiModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

@Module
@InstallIn(ViewModelComponent::class)
class ProductsViewUseCase @Inject constructor(val remoteProductsRepo: RemoteProductsRepo, private val productsUiModelMapper: ProductsUiModelMapper) {
    suspend fun getAllProducts(limit: Int = 10): Flow<List<ProductUiModel>?>{
        try {
//            return remoteProductsRepo.getAllProducts().transform {
//                it?.let {
//                    Log.d("Data", it.products.toString())
//                    ProductsUiModelMapper.INSTANCE.toProductUiModelList(it.products.toMutableList()) }
//
//            }
            remoteProductsRepo.getAllProducts(limit)?.let {
                return flow<List<ProductUiModel>> {
                    val res = productsUiModelMapper.toProductUiModelList(it.products)
                    emit(res)
                }
            }
        }
        catch (e: Throwable){
            Log.e("Data", "${e.message}")
//            return flow {
//                emit(DataRequestError(e.message.toString().orEmpty()))
//            }
            throw  e
        }
        return flow { emit(null) }
    }
}