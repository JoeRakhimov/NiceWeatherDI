package com.joerakhimov.niceweatherdi.forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.joerakhimov.niceweatherdi.R
import com.joerakhimov.niceweatherdi.data.Api
import com.joerakhimov.niceweatherdi.data.BASE_URL
import kotlinx.android.synthetic.main.activity_forecast.*
import kotlinx.coroutines.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ForecastActivity : AppCompatActivity() {

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(Api::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        getForecast()
    }

    @OptIn(DelicateCoroutinesApi::class)
    private fun getForecast() {
        GlobalScope.launch {
            val forecast = api.getForecast()
            withContext(Dispatchers.Main) {
                showForecast(forecast)
            }
        }
    }

    private fun showForecast(forecast: ForecastResponse) {
        title = forecast.location?.name
        if (forecast.daily != null) {
            recycler_forecast.layoutManager = LinearLayoutManager(this)
            recycler_forecast.adapter = ForecastAdapter(forecast.daily)
        }
    }

}