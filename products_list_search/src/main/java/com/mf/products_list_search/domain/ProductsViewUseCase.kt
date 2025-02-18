package com.mf.products_list_search.domain

import android.util.Log
import com.mf.products_list.data.repos.RemoteProductsRepo
import com.mf.products_list_search.domain.models.ProductUiModel
import com.mf.products_list_search.domain.mappers.ProductsUiModelMapper
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import com.mf.products_list_search.domain.models.ProductsSearchUiStates

@Module
@InstallIn(ViewModelComponent::class)
class ProductsViewUseCase @Inject constructor(val remoteProductsRepo: RemoteProductsRepo, private val productsUiModelMapper: ProductsUiModelMapper) {
    suspend fun getAllProducts(limit: Int = 10): Flow<ProductsSearchUiStates<*>>{
        try {
//            return remoteProductsRepo.getAllProducts().transform {
//                it?.let {
//                    Log.d("Data", it.products.toString())
//                    ProductsUiModelMapper.INSTANCE.toProductUiModelList(it.products.toMutableList()) }
//
//            }
            remoteProductsRepo.getAllProducts(limit)?.let {
                val res = productsUiModelMapper.toProductUiModelList(it.products)
                return flow {
                    emit(ProductsSearchUiStates.DataSuccess( res))
                }
            }
        }
        catch (e: Throwable){
//            Log.e("Data", "${e.message}")
//            return flow {
//                emit(DataRequestError(e.message.toString().orEmpty()))
//            }
            return flow { emit(ProductsSearchUiStates.DataError(e.message.orEmpty())) }
//            throw  e
        }
        return flow { emit(ProductsSearchUiStates.DataError("Data retrival error has occurred - Code: 1")) }
    }
}