package com.subbu.assessment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subbu.assessment.model.WeatherInfo
import com.subbu.assessment.network.RetrofitUtility
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    val weatherInfo = MutableLiveData<List<WeatherInfo>>()
    fun getWeatherInfo(locationName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = RetrofitUtility.apiService.getWeatherInfo(locationName, "65d00499677e59496ca2f318eb68c049")
            if(result.code() == 200) {
                weatherInfo.postValue(result.body()?.list)
            } else {
                weatherInfo.postValue(emptyList())
            }
        }
    }
}