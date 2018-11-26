package com.nomtek.domain.api.models.weekforecast

import com.google.gson.annotations.SerializedName

data class WeekForecastWeatherResponseModel(

        @SerializedName("cod")
        var cod: String? = null,

        @SerializedName("message")
        var message: Float? = null,

        @SerializedName("cnt")
        var cnt: Int? = null,

        @SerializedName("list")
        var forecastList: List<Forecast>? = null,

        @SerializedName("city")
        var city: City? = null

)