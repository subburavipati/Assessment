package com.subbu.assessment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subbu.assessment.model.WeatherInfo
import kotlinx.android.synthetic.main.location_weather_detail_item.view.*

class WeatherInfoAdapter(
    private val weatherInfoList: List<WeatherInfo>,
    private val onItemClick: (weatherInfo: WeatherInfo) -> Unit
) :
    RecyclerView.Adapter<WeatherInfoAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.location_weather_detail_item, parent, false), onItemClick
        )
    }

    override fun getItemCount(): Int = weatherInfoList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(weatherInfoList[position])
    }

    class ViewHolder(view: View, val onItemClick: (weatherInfo: WeatherInfo) -> Unit) :
        RecyclerView.ViewHolder(view) {
        fun bind(weatherInfo: WeatherInfo) {
            itemView.setOnClickListener {
                onItemClick(weatherInfo)
            }
            itemView.weatherMain.text = weatherInfo.weather?.get(0)?.main
            itemView.weatherTemp.text = weatherInfo.main?.temp?.toString()
        }
    }
}