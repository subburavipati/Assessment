package com.subbu.assessment.model

import android.os.Parcel
import android.os.Parcelable

data class WeatherResponse(val list: List<WeatherInfo>)
data class WeatherInfo(val main: Main?, val weather: List<Weather>?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readParcelable(Main::class.java.classLoader),
        parcel.createTypedArrayList(Weather)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(main, flags)
        parcel.writeTypedList(weather)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherInfo> {
        override fun createFromParcel(parcel: Parcel): WeatherInfo {
            return WeatherInfo(parcel)
        }

        override fun newArray(size: Int): Array<WeatherInfo?> {
            return arrayOfNulls(size)
        }
    }

}
data class Main(val temp: Double, val feels_like: Double): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(temp)
        parcel.writeDouble(feels_like)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Main> {
        override fun createFromParcel(parcel: Parcel): Main {
            return Main(parcel)
        }

        override fun newArray(size: Int): Array<Main?> {
            return arrayOfNulls(size)
        }
    }

}
data class Weather(val main: String?, val description: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(main)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Weather> {
        override fun createFromParcel(parcel: Parcel): Weather {
            return Weather(parcel)
        }

        override fun newArray(size: Int): Array<Weather?> {
            return arrayOfNulls(size)
        }
    }

}