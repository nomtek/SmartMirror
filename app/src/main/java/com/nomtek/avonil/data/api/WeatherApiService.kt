package com.nomtek.avonil.data.api

import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable

/**
 * Created by avonil on 8/29/17.
 */
interface WeatherApiService {

    companion object {
        const val APPLICATION_ID = "your application id"
    }

    @GET("weather?id=$APPLICATION_ID&lang=pl&units=metric")
    fun fetchCurrentWeather(): Observable<Response<CurrentWeatherResponseModel>>

    @GET("forecast?id=$APPLICATION_ID&lang=pl&units=metric")
    fun fetchWeekForecast(): Observable<Response<WeekForecastWeatherResponseModel>>


}