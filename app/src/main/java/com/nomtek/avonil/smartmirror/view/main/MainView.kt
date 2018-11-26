package com.nomtek.avonil.smartmirror.view.main

import com.nomtek.avonil.smartmirror.view.BaseView
import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel

/**
 * Created by avonil on 9/18/17.
 */
interface MainView : BaseView {

    fun showCurrentWeather(t: CurrentWeatherResponseModel?)

    fun showWeekForecast(t: WeekForecastWeatherResponseModel)

    fun showCurrentAirQuality(caqi: Double?)
}