package com.mf.products_list.data.dataSources.localDataSources

import com.mf.products_list.data.models.ProductDataModel
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//@Module
//@InstallIn(ViewModelComponent::class)
class LocalProductsDataSource @Inject constructor(private val productsDAO: ProductsDAO, ){

    fun getAllProducts(): Flow<List<ProductDataModel>>{
        return productsDAO.getAllProducts()
    }
    fun insertProducts(products: List<ProductDataModel>){
        return productsDAO.insertAllProducts(products)
    }
}