package com.nomtek.avonil.smartmirror.presenter

import com.nomtek.avonil.smartmirror.presenter.base.Presenter
import com.nomtek.avonil.smartmirror.presenter.base.SchedulersProvider
import com.nomtek.avonil.smartmirror.view.main.MainView
import com.nomtek.domain.api.models.quote.AirQualityResponseModel
import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel
import com.nomtek.domain.interactor.DefaultSubscriber
import com.nomtek.domain.interactor.AirQualityInteractor
import com.nomtek.domain.interactor.WeatherInteractor
import rx.Observable
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by avonil on 9/18/17.
 */
class MainViewPresenter @Inject constructor(
        override var schedulersProvider: SchedulersProvider?,
        val weatherInteractor: WeatherInteractor,
        val airQualityInteractor: AirQualityInteractor) : Presenter<MainView>() {

    override fun attach() {
        super.attach()
        fetchCurrentWeather()
        fetchWeekForecast()
        fetchAirQuality()
    }

    private fun fetchAirQuality() {
        Observable.interval(0, 2, TimeUnit.HOURS).map {
            subscribe(airQualityInteractor.fetchAitQuality(), object : DefaultSubscriber<AirQualityResponseModel>() {
                override fun onNext(t: AirQualityResponseModel?) {
                    t?.let {
                       view?.showCurrentAirQuality(t.caqi)
                    }
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }
            })
        }.retry().subscribe()

    }

    private fun fetchWeekForecast() {
        Observable.interval(0, 1, TimeUnit.HOURS).map {
            subscribe(weatherInteractor.fetchWeekForecast(), object : DefaultSubscriber<WeekForecastWeatherResponseModel>() {
                override fun onNext(t: WeekForecastWeatherResponseModel?) {
                    t?.let {
                        view?.showWeekForecast(t)
                    }
                }
            })
        }.retry().subscribe()
    }

    private fun fetchCurrentWeather() {
        Observable.interval(0, 30, TimeUnit.MINUTES).map {
            subscribe(weatherInteractor.fetchCurrentWeather(), object : DefaultSubscriber<CurrentWeatherResponseModel>() {
                override fun onNext(t: CurrentWeatherResponseModel?) {
                    view?.showCurrentWeather(t)
                }
            })
        }.retry().subscribe()
    }

}