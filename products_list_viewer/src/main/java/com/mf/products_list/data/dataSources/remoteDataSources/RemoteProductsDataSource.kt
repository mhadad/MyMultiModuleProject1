package com.mf.products_list.data.dataSources.remoteDataSources

import com.mf.products_list.data.models.ProductsDataModel
import kotlinx.coroutines.flow.Flow
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteProductsDataSource {
    @GET("/products")
//        suspend fun getProducts(@Query("limit") limit : Int = 0): Response<ProductsDataModel>
    suspend fun getProducts(@Query("limit") limit : Int = 0): Response<ResponseBody>

}