package com.mf.products_list.data.dataSources.remoteDataSources

import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class RetrofitInstance @Inject constructor() {
    @Provides
    fun provideRetrofit(BASE_URL: String): RemoteProductsDataSource {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(RetryInterceptor(maxRetries = 3))
            .addInterceptor(loggingInterceptor)
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder().build()))
//            .addConverterFactory(MoshiConverterFactory.create())
            .client(okHttpClient)
            .build().create(RemoteProductsDataSource::class.java)
    }
}