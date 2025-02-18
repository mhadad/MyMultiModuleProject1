package com.mf.products_list.data.dataSources.localDataSources

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RoomDBModule @Inject constructor() {


    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): RoomDB {
        return Room.databaseBuilder(
            context.applicationContext,
            RoomDB::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideUserDao(database: RoomDB): ProductsDAO {
        return database.productsDao()
    }
}