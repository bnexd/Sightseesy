package com.tomtom.router.ui.trips.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.tomtom.router.databinding.ViewholderPoiBinding
import com.tomtom.router.model.Poi
import com.tomtom.router.model.PoiDiffCallback

class PoiAdapter(private val listener: PoiClickListener) :
    ListAdapter<Poi, PoiViewHolder>(
        PoiDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewholderPoiBinding.inflate(layoutInflater, parent, false)
        return PoiViewHolder(binding)
    }

    fun getPoiAt(position: Int): Poi = getItem(position)

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface PoiClickListener {
        fun onPoiClicked(poi: Poi)
    }
}