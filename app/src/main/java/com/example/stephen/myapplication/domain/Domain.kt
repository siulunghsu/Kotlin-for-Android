package com.example.stephen.myapplication.domain

/**
 * Created by stephen on 03/11/2017.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>) {
    operator fun get(position: Int): Forecast = dailyForecast[position]
    fun size(): Int = dailyForecast.size
}


data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int)