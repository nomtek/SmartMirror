package com.nomtek.domain.api.models.weather.current

import com.google.gson.annotations.SerializedName

data class Main(

        @SerializedName("temp")
        var temp: String? = null,

        @SerializedName("pressure")
        var pressure: String? = null,

        @SerializedName("humidity")
        var humidity: String? = null,

        @SerializedName("temp_min")
        var tempMin: String? = null,

        @SerializedName("temp_max")
        var tempMax: String? = null

)