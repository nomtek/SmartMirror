package com.nomtek.avonil.smartmirror.view.main

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import com.nomtek.domain.api.models.weekforecast.Forecast

/**
 * Created by Damian Kwasniak on 9/20/17.
 */
class WeatherRecycleView @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr) {

    val weatherRecyclerViewAdapter: WeatherRecyclerViewAdapter = WeatherRecyclerViewAdapter()

    val linearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)


    init {
        adapter = weatherRecyclerViewAdapter
        layoutManager = linearLayoutManager
    }

    fun setItems(items: List<Forecast>) {
        weatherRecyclerViewAdapter.items = items
        weatherRecyclerViewAdapter.notifyDataSetChanged()
    }
}