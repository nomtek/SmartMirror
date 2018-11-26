package com.nomtek.domain.api.models.weekforecast

import com.nomtek.domain.api.models.weather.current.Coord
import com.google.gson.annotations.SerializedName

data class City(

        @SerializedName("id")
        var id: Int? = null,

        @SerializedName("name")
        var name: String? = null,

        @SerializedName("coord")
        var coord: Coord? = null,

        @SerializedName("country")
        var country: String? = null

)