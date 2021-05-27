package com.subbu.assessment.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitUtility {

    private const val BASE_URL = "https://api.openweathermap.org"

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build() //Doesn't require the adapter
    }

    val apiService: WeatherApi = getRetrofit()
        .create(WeatherApi::class.java)
}