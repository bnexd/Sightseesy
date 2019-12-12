package com.tomtom.router.ui.trips.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tomtom.router.databinding.ViewholderPoiBinding
import com.tomtom.router.model.Poi

class PoiViewHolder(val binding: ViewholderPoiBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(poi: Poi, listener: PoiAdapter.PoiClickListener) {
        binding.poi = poi
        binding.root.setOnClickListener { listener.onPoiClicked(poi) }
        binding.executePendingBindings()
    }
}