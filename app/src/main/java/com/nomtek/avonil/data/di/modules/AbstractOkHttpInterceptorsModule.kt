package com.nomtek.avonil.data.di.modules

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import com.nomtek.avonil.data.di.qualifiers.OkHttpInterceptors
import com.nomtek.avonil.data.di.qualifiers.OkHttpNetworkInterceptors
import java.util.*
import javax.inject.Singleton

/**
 * Created by wojciechmatyja on 17.07.2017.
 */

@Module
abstract class AbstractOkHttpInterceptorsModule {

    @Provides
    @Singleton
    @OkHttpInterceptors
    fun provideOkHttpInterceptors(httpLoggingInterceptor: HttpLoggingInterceptor): MutableList<Interceptor> {
        return Arrays.asList<Interceptor>(httpLoggingInterceptor)
    }

    @Provides
    @Singleton
    @OkHttpNetworkInterceptors
    internal fun provideOkHttpNetworkInterceptors(): MutableList<Interceptor> {
        return mutableListOf()
    }
}
