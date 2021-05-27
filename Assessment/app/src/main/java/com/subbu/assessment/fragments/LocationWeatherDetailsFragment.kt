package com.subbu.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.subbu.assessment.R
import com.subbu.assessment.WeatherInfoAdapter
import com.subbu.assessment.viewmodel.WeatherViewModel
import kotlinx.android.synthetic.main.fragment_location_weather_details.*

class LocationWeatherDetailsFragment: Fragment() {

    companion object {
        const val LOCATION_NAME = "LOCATION_NAME"
    }

    lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        weatherViewModel = ViewModelProvider(this).get(WeatherViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_location_weather_details, container, false)
    }

    override fun onResume() {
        super.onResume()
        val cityName = arguments?.getString(LOCATION_NAME)
        (activity as AppCompatActivity).supportActionBar?.apply {
            show()
            setDisplayHomeAsUpEnabled(true)
            title = cityName
        }

        progressBar.visibility = View.VISIBLE
        weatherViewModel.apply {
            getWeatherInfo(cityName ?: "")
            weatherInfo.observe(this@LocationWeatherDetailsFragment, Observer { list ->
                if(list.isEmpty()) {
                    Toast.makeText(activity, "Something went wrong while fetching", Toast.LENGTH_SHORT).show()
                    return@Observer
                }
                progressBar.visibility = View.GONE
                val adapter =
                    WeatherInfoAdapter(list) { item ->
                        val args = Bundle().apply {
                            putParcelable(
                                WeatherDetailDescriptionFragment.WEATHER_ITEM,
                                item
                            )
                        }
                        view?.findNavController()?.navigate(
                            R.id.locationWeatherDetailsToWeatherDetailsDescription,
                            args
                        )
                    }
                locationWeatherDetails.adapter = adapter
            })
        }
    }
}