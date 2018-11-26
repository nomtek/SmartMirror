package com.nomtek.avonil.smartmirror.view.main

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nomtek.avonil.smartmirror.R
import com.nomtek.avonil.smartmirror.utils.ImageUtils
import com.nomtek.domain.api.models.weekforecast.Forecast
import kotlinx.android.synthetic.main.forecast_list_item.view.*

/**
 * Created by Damian Kwasniak on 9/20/17.
 */
class WeatherRecyclerViewAdapter : RecyclerView.Adapter<WeatherRecyclerViewAdapter.ViewHolder>() {

    var items: List<Forecast> = mutableListOf()


    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(items[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.forecast_list_item, parent, false)
        return ViewHolder(view)
    }


    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(model: Forecast) {
            view.dayNameTextView.text = com.nomtek.domain.utils.DateUtils.getDayNameForDate(model.dt!!.toLong() * 1000)
            view.weatherConditionIcon.setImageDrawable(ImageUtils.getDrawableWithCode(view.context, model.weather!![0].icon))
            view.maxTempTextView.text = String.format(view.resources.getString(R.string.temprature), model.main!!.tempMax!!)
            view.minTempTextView.text = String.format(view.resources.getString(R.string.temprature), model.main!!.tempMin!!)
        }
    }

}