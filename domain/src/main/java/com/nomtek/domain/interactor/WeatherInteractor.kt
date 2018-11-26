package com.nomtek.domain.interactor

import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.Forecast
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel
import com.nomtek.domain.repository.WeatherRepository
import com.nomtek.domain.utils.DateUtils
import rx.Observable
import javax.inject.Inject

/**
 * Created by Damian Kwasniak on 9/20/17.
 */
class WeatherInteractor @Inject constructor(val weatherRepository: WeatherRepository) {

    fun fetchCurrentWeather(): Observable<CurrentWeatherResponseModel> {
        return weatherRepository.fetchCurrentWeather()
    }

    fun fetchWeekForecast(): Observable<WeekForecastWeatherResponseModel> {
        return weatherRepository.fetchWeekForecast().map {
            val currentDateString = DateUtils.formatDate(System.currentTimeMillis())
            val listWithoutToday = it.forecastList?.filter { !it.dtTxt!!.startsWith(currentDateString) } // usun dzisiejszy dzien
            val resultList = mutableListOf<Forecast>()

            val byDay = listWithoutToday?.groupBy { it.dtTxt!!.split(" ")[0] }
            byDay?.forEach { _, list ->

                var currentMin = Int.MAX_VALUE
                var currentMax = Int.MIN_VALUE
                list.forEach{
                    if(it.main!!.tempMax!!.toDouble().toInt() > currentMax) {
                        currentMax = it.main!!.tempMax!!.toDouble().toInt()
                    }

                    if(it.main!!.tempMin!!.toDouble().toInt() < currentMin) {
                        currentMin = it.main!!.tempMin!!.toDouble().toInt()
                    }
                }

                var middleDayItem = list.find {it.dtTxt!!.contains("12:00:00")}

                if( middleDayItem != null) {
                } else  {
                    middleDayItem = list[0]
                }
                middleDayItem.main!!.tempMax = currentMax.toString()
                middleDayItem.main!!.tempMin = currentMin.toString()
                resultList.add(middleDayItem)
            }

            //val resultList = listWithoutToday?.filter { it.dtTxt!!.contains("12:00:00") }
            it.forecastList = resultList
            it
        }
    }

}