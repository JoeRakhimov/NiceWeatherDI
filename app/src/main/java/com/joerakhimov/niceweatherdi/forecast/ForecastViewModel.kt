package com.joerakhimov.niceweatherdi.forecast

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joerakhimov.niceweatherdi.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.text.Typography.dagger

@HiltViewModel
class ForecastViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private val _forecast = MutableLiveData<ForecastResponse>()
    val forecast: LiveData<ForecastResponse> = _forecast

    init {
        getForecast()
    }

    private fun getForecast() {
        viewModelScope.launch {
            _forecast.value = repository.getForecast()
        }
    }

}