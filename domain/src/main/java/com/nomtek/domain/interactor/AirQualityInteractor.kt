package com.nomtek.domain.interactor

import com.nomtek.domain.api.models.quote.AirQualityResponseModel
import com.nomtek.domain.repository.AirQualityRepository
import rx.Observable
import javax.inject.Inject

/**
 * Created by Damian Kwasniak on 9/21/17.
 */
class AirQualityInteractor @Inject constructor(val airQualityRepository: AirQualityRepository) {

    fun fetchAitQuality(): Observable<AirQualityResponseModel> {
        return airQualityRepository.fetchAirQuality().map {
            it.last()
        }
    }
}