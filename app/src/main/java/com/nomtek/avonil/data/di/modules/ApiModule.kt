package com.nomtek.avonil.data.di.modules

import com.nomtek.avonil.data.api.QuoteApiService
import com.nomtek.avonil.data.api.WeatherApiService
import com.nomtek.avonil.data.di.modules.converter.NullOnEmptyConverterFactory
import com.nomtek.avonil.data.di.qualifiers.QuoteRetrofit
import com.nomtek.avonil.data.di.qualifiers.WeatherRetrofit
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by Damian Kwasniak on 20.04.17.
 */
@Module
class ApiModule(val weatherApiUrl: String, val quoteApiUrl: String) {


    @Provides
    @Singleton
    @WeatherRetrofit
    fun provideWeatherRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(weatherApiUrl)
                .client(okHttpClient)
                .addConverterFactory(NullOnEmptyConverterFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    @Singleton
    @QuoteRetrofit
    fun provideQuoteRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(quoteApiUrl)
                .client(okHttpClient)
                .addConverterFactory(NullOnEmptyConverterFactory())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    @Singleton
    fun provideWeatherApiService(@WeatherRetrofit retrofit: Retrofit): WeatherApiService {
        return retrofit.create(WeatherApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideQuoteService(@QuoteRetrofit retrofit: Retrofit): QuoteApiService {
        return retrofit.create(QuoteApiService::class.java)
    }

}