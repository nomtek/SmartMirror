package com.nomtek.domain.api.models.weather.current

import com.google.gson.annotations.SerializedName

data class Wind (

    @SerializedName("speed")
    var speed: Float? = null,

    @SerializedName("deg")
    var deg: String? = null

)