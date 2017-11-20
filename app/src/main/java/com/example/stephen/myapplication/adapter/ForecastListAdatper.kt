package com.example.stephen.myapplication.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.stephen.myapplication.domain.ForecastList

/**
 * Created by stephen on 2017/10/30.
 */
//class ForecastListAdatper(val items: List<String>): RecyclerView.Adapter<ForecastListAdatper.ViewHolder>() {
//    override fun getItemCount(): Int = items.size
//
//    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        holder?.textView?.text = items[position]
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//        return ViewHolder(TextView(parent?.context))
//    }
//
//
//    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
//}

class ForecastListAdatper(val weekForecast: ForecastList): RecyclerView.Adapter<ForecastListAdatper.ViewHolder>() {
    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
//        with(weekForecast.dailyForecast[position]) {
//            holder?.textView?.text = "$date - $description - $high/$low"
//        }
        with(weekForecast[position]) {
            holder?.textView?.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent?.context))
    }

    override fun getItemCount(): Int = weekForecast.size()


    class ViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)

    operator fun ViewGroup.get(position: Int): View = getChildAt(position)
}

//class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)