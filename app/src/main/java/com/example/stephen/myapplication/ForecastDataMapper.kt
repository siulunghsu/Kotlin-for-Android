package com.example.stephen.myapplication

import android.annotation.SuppressLint
import android.icu.text.DateFormat
import com.example.stephen.myapplication.date.Forecast
import com.example.stephen.myapplication.domain.Forecast as ModelForecast
import com.example.stephen.myapplication.date.ForecastResult
import com.example.stephen.myapplication.domain.ForecastList
import java.util.*

/**
 * Created by stephen on 03/11/2017.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult) : ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }
    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    @SuppressLint("NewApi")
    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }



}