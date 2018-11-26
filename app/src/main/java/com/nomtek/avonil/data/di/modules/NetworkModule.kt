package com.nomtek.avonil.data.di.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    var CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MB

    private val TIMEOUT_LENGTH_IN_SECONDS: Long = 30

    @Provides
    @Singleton
    fun provideOkHttpClient(aplication: Application):
            OkHttpClient {

        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.connectTimeout(TIMEOUT_LENGTH_IN_SECONDS, TimeUnit.SECONDS)
        okHttpBuilder.readTimeout(TIMEOUT_LENGTH_IN_SECONDS, TimeUnit.SECONDS)
        okHttpBuilder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS))

        return okHttpBuilder.build()
    }

}
