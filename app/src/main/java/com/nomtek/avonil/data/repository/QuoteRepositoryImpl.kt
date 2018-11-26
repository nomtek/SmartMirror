package com.nomtek.avonil.data.repository

import com.nomtek.avonil.data.api.QuoteApiService
import com.nomtek.domain.api.models.quote.AirQualityResponseModel
import com.nomtek.domain.repository.AirQualityRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Damian Kwasniak on 9/21/17.
 */
class QuoteRepositoryImpl @Inject constructor(val airQualityApiService: QuoteApiService): AirQualityRepository, BaseRepository(){

    override fun fetchAirQuality(): Observable<List<AirQualityResponseModel>> {
        return airQualityApiService.fetchAirQuality().flatMap {
            parseResponse(it)
        }
    }
}