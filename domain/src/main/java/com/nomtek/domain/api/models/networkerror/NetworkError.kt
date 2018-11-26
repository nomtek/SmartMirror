package com.nomtek.domain.api.models.networkerror

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException

/**
 * Created by Damian Kwasniak on 16.05.17.
 */
open class NetworkError(
        var code: Int? = 0,
        protected open var constructorErrorBody: String? = null

) : RuntimeException(constructorErrorBody) {

    private val gson = Gson()

    var errorBody: String? = null
        get() = getErrorMessage()


    private fun getErrorMessage(): String {
        try {
            constructorErrorBody?.let {
                return gson.fromJson(constructorErrorBody, HttpFailureApiModel::class.java).message
            }
        } catch (e: JsonSyntaxException) {
            return constructorErrorBody ?: ""
        }
        return ""
    }

}