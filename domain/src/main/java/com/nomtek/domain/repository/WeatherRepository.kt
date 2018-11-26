package com.nomtek.domain.repository

import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel
import rx.Observable

/**
* Created by Damian Kwasniak on 9/19/17.
*/
interface WeatherRepository {

    fun fetchCurrentWeather(): Observable<CurrentWeatherResponseModel>

    fun fetchWeekForecast(): Observable<WeekForecastWeatherResponseModel>
}