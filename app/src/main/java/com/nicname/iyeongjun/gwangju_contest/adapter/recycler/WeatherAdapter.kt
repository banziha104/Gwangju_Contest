package com.nicname.iyeongjun.gwangju_contest.adapter.recycler

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.nicname.iyeongjun.gwangju_contest.GlideApp
import com.nicname.iyeongjun.gwangju_contest.R


class WeatherAdapter(val context : Context) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_weather,parent,false)
        return WeatherViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val id = context.resources.getIdentifier("card_${position+1}","drawable",context.packageName)
        GlideApp
                .with(context)
                .load(id)
                .into(holder.img)
    }

    inner class WeatherViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.weatherItem)
    }
}