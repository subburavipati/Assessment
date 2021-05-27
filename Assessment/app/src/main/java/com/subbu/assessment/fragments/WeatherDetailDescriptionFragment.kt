package com.subbu.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.subbu.assessment.R
import com.subbu.assessment.model.WeatherInfo
import kotlinx.android.synthetic.main.fragment_weather_details_description.view.*

class WeatherDetailDescriptionFragment: Fragment() {

    companion object {
        const val WEATHER_ITEM = "WEATHER_ITEM"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_details_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weatherInfo = arguments?.getParcelable<WeatherInfo>(
            WEATHER_ITEM
        )
        view.apply {
            weatherDetailsTemp.text = weatherInfo?.main?.temp?.toString()
            weatherDetailsFeelsLike.text = context.getString(R.string.feels_like, weatherInfo?.main?.feels_like?.toString())
            weatherDetailsWeatherType.text = weatherInfo?.weather?.get(0)?.main
            weatherDetailsWeatherDescription.text = weatherInfo?.weather?.get(0)?.description
        }
    }
}