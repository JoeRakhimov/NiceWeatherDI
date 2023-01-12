package com.joerakhimov.niceweatherdi.data

import com.joerakhimov.niceweatherdi.forecast.ForecastResponse
import retrofit2.http.GET

const val BASE_URL = "http://api.joerakhimov.com"

interface Api {

    @GET("/weather/forecast")
    suspend fun getForecast(): ForecastResponse

}