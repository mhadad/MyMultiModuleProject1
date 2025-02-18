package com.mf.products_list.data.dataSources.localDataSources

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mf.products_list.data.dataSources.converters.ProductDataModelConverter
import com.mf.products_list.data.models.ProductDataModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//@Module
//@InstallIn(SingletonComponent::class)
@Database(entities = [ProductDataModel::class], version = 1, exportSchema = false)
@TypeConverters(ProductDataModelConverter::class)
abstract class RoomDB  : RoomDatabase(){
//    private var INSTANCE: RoomDB? = null

//    @Provides
    abstract fun productsDao(): ProductsDAO

//    @Provides
//    fun getInstance(context: Context): RoomDB {
//        return INSTANCE ?: synchronized(this) {
//            val instance = Room.databaseBuilder(
//                context.applicationContext,
//                RoomDB::class.java,
//                "app_database"
//            ).build()
//            INSTANCE = instance
//            instance
//        }
//    }
//    override fun createInvalidationTracker(): InvalidationTracker {
//        TODO("Not yet implemented: createInvalidationTracker")
//    }
//
//    override fun clearAllTables() {
//        TODO("Not yet implemented: clearAllTables")
//    }
}