package com.nomtek.domain.di.module

import com.nomtek.domain.interactor.AirQualityInteractor
import com.nomtek.domain.interactor.WeatherInteractor
import com.nomtek.domain.repository.AirQualityRepository
import com.nomtek.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by avonil on 9/18/17.
 */

@Module
class DomainModule {

    @Singleton
    @Provides
    fun provideWeatherInteractor(weatherRepository: WeatherRepository): WeatherInteractor {
        return WeatherInteractor(weatherRepository)
    }

    @Singleton
    @Provides
    fun provideQuoteInteractor(quoteRepository: AirQualityRepository): AirQualityInteractor {
        return AirQualityInteractor(quoteRepository)
    }
}