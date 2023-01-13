package com.joerakhimov.niceweatherdi.data

import com.joerakhimov.niceweatherdi.forecast.ForecastResponse

interface Repository {
    suspend fun getForecast(): ForecastResponse
}