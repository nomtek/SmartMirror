package com.nomtek.avonil.di.modul

import android.app.Application
import android.content.Context
import android.support.annotation.NonNull
import com.nomtek.avonil.data.api.QuoteApiService
import com.nomtek.avonil.data.api.WeatherApiService
import com.nomtek.avonil.data.repository.QuoteRepositoryImpl
import com.nomtek.avonil.data.repository.WeatherRepositoryImpl
import com.nomtek.avonil.smartmirror.presenter.base.SchedulersProvider
import com.nomtek.domain.repository.AirQualityRepository
import com.nomtek.domain.repository.WeatherRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Singleton

/**
 * Created by wojciechmatyja on 20.04.2017.
 */

@Module
class ApplicationModule(@NonNull var application: Application) {

    @Provides
    @Singleton
    fun provideContext(): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
                .create()
    }

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return application
    }

    @Provides
    @Singleton
    fun provideSchedulersProvider(): SchedulersProvider {
        return object : SchedulersProvider {
            override fun getIOScheduler(): Scheduler {
                return Schedulers.io()
            }

            override fun getMainThreadScheduler(): Scheduler {
                return AndroidSchedulers.mainThread()
            }
        }
    }

    @Singleton
    @Provides
    fun provideWeatherRepository(weatherApiService: WeatherApiService): WeatherRepository {
        return WeatherRepositoryImpl(weatherApiService)
    }

    @Singleton
    @Provides
    fun provideQuoteRepository(quoteApiService: QuoteApiService): AirQualityRepository {
        return QuoteRepositoryImpl(quoteApiService)
    }


}