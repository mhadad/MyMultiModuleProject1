package com.mf.products_list.data.dataSources.remoteDataSources

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class RetryInterceptor(
    private val maxRetries: Int = 3,
    private val initialDelay: Long = 1000L // 1 second
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var attempt = 0
        var delay = initialDelay
        var response: Response

        do {
            try {
                response = chain.proceed(chain.request())
                if (response.isSuccessful) return response
            } catch (e: IOException) {
                if (attempt >= maxRetries) throw e
            }

            attempt++
            Thread.sleep(delay)
            delay *= 2 // Exponential backoff
        } while (attempt < maxRetries)

        throw IOException("Max retry limit reached")
    }
}