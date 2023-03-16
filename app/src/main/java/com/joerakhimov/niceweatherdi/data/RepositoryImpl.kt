package com.joerakhimov.niceweatherdi.data

import com.joerakhimov.niceweatherdi.forecast.ForecastResponse
import javax.inject.Inject

//class RepositoryImpl (private val api: Api): Repository {
//    override suspend fun getForecast(): ForecastResponse {
//        return api.getForecast()
//    }
//}

class RepositoryImpl @Inject constructor(private val api: Api): Repository {
    override suspend fun getForecast(): ForecastResponse {
        return api.getForecast()
    }
}