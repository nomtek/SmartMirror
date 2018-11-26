package com.nomtek.avonil.data.repository

import com.nomtek.avonil.data.api.WeatherApiService
import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel
import com.nomtek.domain.repository.WeatherRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by avonil on 8/29/17.
 */
class WeatherRepositoryImpl @Inject constructor(private val weatherApiService: WeatherApiService) :
        WeatherRepository,  BaseRepository() {

    override fun fetchCurrentWeather(): Observable<CurrentWeatherResponseModel> {
        return weatherApiService.fetchCurrentWeather().flatMap {
            parseResponse(it)
        }
    }

    override fun fetchWeekForecast(): Observable<WeekForecastWeatherResponseModel> {
        return weatherApiService.fetchWeekForecast().flatMap {
            parseResponse(it)
        }
    }


}