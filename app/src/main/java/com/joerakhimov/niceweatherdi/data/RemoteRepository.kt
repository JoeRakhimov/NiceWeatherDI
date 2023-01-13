package com.joerakhimov.niceweatherdi.data

import android.util.Log
import com.joerakhimov.niceweatherdi.forecast.ForecastResponse
import javax.inject.Inject

class RemoteRepository @Inject constructor(private val api: Api): Repository {
    override suspend fun getForecast(): ForecastResponse {
        Log.d("DITag", api.toString())
        return api.getForecast()
    }
}