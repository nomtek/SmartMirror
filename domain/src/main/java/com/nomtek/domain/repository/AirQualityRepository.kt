package com.nomtek.domain.repository

import com.nomtek.domain.api.models.quote.AirQualityResponseModel
import rx.Observable

/**
 * Created by Damian Kwasniak on 9/21/17.
 */
interface AirQualityRepository {

    fun fetchAirQuality(): Observable<List<AirQualityResponseModel>>
}