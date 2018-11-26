package com.nomtek.domain.api.models.networkerror

import com.google.gson.annotations.SerializedName


data class HttpFailureApiModel(
        @SerializedName("message")
        val message: String
)