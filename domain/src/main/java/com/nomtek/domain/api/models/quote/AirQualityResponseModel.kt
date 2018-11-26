package com.nomtek.domain.api.models.quote

import com.google.gson.annotations.SerializedName

data class AirQualityResponseModel(

        @SerializedName("id")
        var id: String? = null,

        @SerializedName("caqi")
        var caqi: Double? = null

)