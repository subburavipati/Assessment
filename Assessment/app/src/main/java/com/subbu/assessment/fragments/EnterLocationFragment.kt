package com.subbu.assessment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.subbu.assessment.R
import kotlinx.android.synthetic.main.fragment_enter_location.*

class EnterLocationFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enter_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lookup.setOnClickListener {
            val locationName = locationName.text.toString()
            if(locationName.isEmpty()) {
                Toast.makeText(activity, "Enter Location Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val args = Bundle().apply {
                putString(LocationWeatherDetailsFragment.LOCATION_NAME, locationName)
            }
            view.findNavController().navigate(R.id.enterLocationToLocationWeatherDetails, args)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.hide()
    }
}