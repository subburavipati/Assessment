package com.subbu.assessment.network

import com.subbu.assessment.model.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("/data/2.5/forecast")
    suspend fun getWeatherInfo(@Query("q") q: String, @Query("appid") appid: String): Response<WeatherResponse>
}