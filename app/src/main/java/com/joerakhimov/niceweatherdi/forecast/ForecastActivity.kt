package com.joerakhimov.niceweatherdi.forecast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.joerakhimov.niceweatherdi.R
import com.joerakhimov.niceweatherdi.data.Api
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_forecast.*
import javax.inject.Inject

@AndroidEntryPoint
class ForecastActivity : AppCompatActivity() {

    private val forecastViewModel: ForecastViewModel by viewModels()

    @Inject
    lateinit var api: Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        forecastViewModel.getForecast()
        forecastViewModel.forecast.observe(this) { forecast ->
            showForecast(forecast)
        }
        Log.d("DITag", api.toString())
    }

    private fun showForecast(forecast: ForecastResponse) {
        title = forecast.location?.name
        if (forecast.daily != null) {
            recycler_forecast.layoutManager = LinearLayoutManager(this)
            recycler_forecast.adapter = ForecastAdapter(forecast.daily)
        }
    }

}