package com.mf.products_list.presentation

import android.content.Context
import com.mf.products_list.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class AppDependencies @Inject constructor() {


    @Provides
    fun provideBaseUrl(@ApplicationContext context: Context): String = context.getString(R.string.BASE_URL)

}