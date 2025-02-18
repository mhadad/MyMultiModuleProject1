package com.mf.products_list.data.dataSources.localDataSources

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mf.products_list.data.models.ProductDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductsDAO {
    @Insert
    fun insertAllProducts(productsList: List<ProductDataModel>)

    @Query("SELECT * FROM products ORDER BY id DESC")
    fun getAllProducts(): Flow<List<ProductDataModel>>
}