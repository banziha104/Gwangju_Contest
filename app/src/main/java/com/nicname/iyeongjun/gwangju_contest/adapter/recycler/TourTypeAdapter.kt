package com.nicname.iyeongjun.gwangju_contest.adapter.recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.nicname.iyeongjun.gwangju_contest.R
import io.reactivex.subjects.BehaviorSubject


class TourTypeAdapter(val list : List<String>, val driver : BehaviorSubject<String>) : RecyclerView.Adapter<TourTypeAdapter.TourTypeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TourTypeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_type,parent,false)
        return TourTypeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TourTypeViewHolder, position: Int) {
        holder.apply {
            text = list[position]
            textView.text = list[position]
        }
    }

    inner class TourTypeViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val textView = view.findViewById<TextView>(R.id.txtTourType)
        var text : String? = null
        init {
            textView.setOnClickListener {
                driver.onNext(text!!)
            }
        }
    }
}