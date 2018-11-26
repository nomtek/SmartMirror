package com.nomtek.avonil.smartmirror

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.nomtek.avonil.smartmirror.presenter.MainViewPresenter
import com.nomtek.avonil.smartmirror.utils.ImageUtils
import com.nomtek.avonil.smartmirror.view.main.MainView
import com.nomtek.domain.api.models.weather.current.CurrentWeatherResponseModel
import com.nomtek.domain.api.models.weekforecast.WeekForecastWeatherResponseModel
import com.nomtek.domain.utils.DateUtils
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : Activity(), MainView {

    @Inject
    lateinit var presenter: MainViewPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SmartMirrorApplication.applicationComponent.inject(this)
        setContentView(R.layout.activity_main)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.bindView(this)
        presenter.attach()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.detach()
        presenter.unbindView(this)
    }

    override fun showCurrentWeather(model: CurrentWeatherResponseModel?) {
        if (model != null) {
            todayTempTextView.text = String.format(resources.getString(R.string.temprature), model.main?.temp)
            sunRiseTextView.text = DateUtils.formatTime(model.sys?.sunrise?.toLong()!! * 1000)
            sunSetTextView.text = DateUtils.formatTime(model.sys?.sunset?.toLong()!! * 1000)
            weatherConditionIcon.setImageDrawable(ImageUtils.getDrawableWithCode(this, model.weather?.get(0)?.icon))
            todayWeatherLayout.visibility = View.VISIBLE
        }
    }

    override fun showWeekForecast(t: WeekForecastWeatherResponseModel) {
        t.forecastList?.let {
            weatherRecyclerView.setItems(t.forecastList!!)
        }
    }

    override fun showCurrentAirQuality(caqi: Double?) {
        caqi?.let {
            airConditionStateTextView.setText(getQualityRes(caqi))
            airConditionContainer.visibility = View.VISIBLE
        }
    }

    private fun getQualityRes(caqi: Double): Int {
        return when {
            caqi in 0..24 -> R.string.air_quality_very_low
            caqi in 25..49 -> R.string.air_quality_low
            caqi in 50..74 -> R.string.air_quality_medium
            caqi in 75..100 -> R.string.air_quality_bad
            caqi > 100 -> R.string.air_quality_very_bad
            else -> {
                R.string.air_quality_missing
            }
        }
    }
}
