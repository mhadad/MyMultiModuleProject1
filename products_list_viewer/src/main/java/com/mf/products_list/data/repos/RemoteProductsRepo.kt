package com.mf.products_list.data.repos

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mf.products_list.data.dataSources.localDataSources.LocalProductsDataSource
import com.mf.products_list.data.dataSources.remoteDataSources.RemoteProductsDataSource
import com.mf.products_list.data.models.ProductsDataModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.transform
import retrofit2.await
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class RemoteProductsRepo @Inject constructor(private val remoteApiService: RemoteProductsDataSource, private val localDataSource: LocalProductsDataSource) {
//    private var _productsFlow : MutableStateFlow<ProductsDataModel?> = MutableStateFlow(value = null)
//    val productsFlow : StateFlow<ProductsDataModel?> = _productsFlow
    suspend fun getAllProducts(limit: Int = 10): ProductsDataModel?{
//suspend fun getAllProducts(limit: Int = 10){
//        val products = localDataSource.getAllProducts()
//        if(products != null)
//            _productsFlow.emit(ProductsDataModel(products = products , total = 0, ))
//            return products.map { return@map ProductsDataModel(products = it, total = it.size, 0, 0) }
//        else if(products == null) {
            val response = remoteApiService.getProducts(limit)
//            val productsObj = response.await()
        if(response.isSuccessful){
//            if(productsObj != null) {
//                val productsData = products.body()
//                val productsObj = response.body()
//                if(productsData != null) {
//                productsObj?.let {
//                    localDataSource.insertProducts(it.products)
//                }
            val jsonStr = response.body()?.string().orEmpty()
            val typeT = object: TypeToken<ProductsDataModel>(){}.type
            val products = Gson().fromJson<ProductsDataModel>(jsonStr, typeT )
            return products
//                return  productsObj
//                    return flow {
//                        emit(response)
//                    }
//                }
//            }
//        }
    }
        throw Error("Network error has occurred")

        }
}