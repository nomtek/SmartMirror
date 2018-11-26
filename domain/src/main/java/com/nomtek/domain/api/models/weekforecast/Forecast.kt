package com.nomtek.domain.api.models.weekforecast

import com.nomtek.domain.api.models.weather.current.*
import com.google.gson.annotations.SerializedName

data class Forecast(

        @SerializedName("dt")
        var dt: Int? = null,

        @SerializedName("main")
        var main: Main? = null,

        @SerializedName("weather")
        var weather: List<Weather>? = null,

        @SerializedName("clouds")
        var clouds: Clouds? = null,

        @SerializedName("wind")
        var wind: Wind? = null,

        @SerializedName("rain")
        var rain: Rain? = null,

        @SerializedName("sys")
        var sys: Sys? = null,

        @SerializedName("dt_txt")
        var dtTxt: String? = null


) : Comparable<Forecast> {

    override fun compareTo(other: Forecast): Int {
        val minTemp = this.main!!.tempMin!!.toDouble().toInt()
        val otherMinTemp = other.main!!.tempMin!!.toDouble().toInt()

        if (minTemp < otherMinTemp) {
            return -1
        } else if (minTemp > otherMinTemp) {
            return 1
        } else {
            return 0
        }
    }
}