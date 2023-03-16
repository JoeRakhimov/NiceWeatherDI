package com.joerakhimov.niceweatherdi.forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.joerakhimov.niceweatherdi.R
import com.joerakhimov.niceweatherdi.data.Api
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_forecast.*
import kotlinx.coroutines.*
import javax.inject.Inject
import kotlin.text.Typography.dagger

@AndroidEntryPoint
class ForecastActivity : AppCompatActivity() {

    @Inject
    lateinit var api: Api

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
        if(forecast.daily!=null){
            recycler_forecast.layoutManager = LinearLayoutManager(this)
            recycler_forecast.adapter = ForecastAdapter(forecast.daily)
        }
    }

}