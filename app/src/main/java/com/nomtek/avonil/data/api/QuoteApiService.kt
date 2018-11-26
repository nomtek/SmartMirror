package com.nomtek.avonil.data.api

import com.nomtek.domain.api.models.quote.AirQualityResponseModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import rx.Observable

/**
 * Created by Damian Kwasniak on 9/21/17.
 */
interface QuoteApiService {


    @Headers("Accept: application/json")
    @GET("dust_records")
    fun fetchAirQuality(): Observable<Response<List<AirQualityResponseModel>>>

}