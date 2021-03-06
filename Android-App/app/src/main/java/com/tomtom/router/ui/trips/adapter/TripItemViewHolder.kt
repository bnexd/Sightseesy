package com.tomtom.router.ui.trips.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import com.tomtom.router.databinding.ViewholderTripBinding
import com.tomtom.router.model.TripItem

class TripItemViewHolder(val binding: ViewholderTripBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(tripItem: TripItem, listener: TripItemAdapter.TripItemClickListener) {
        binding.trip = tripItem
        binding.root.setOnClickListener { listener.onTripItemClicked(tripItem) }
        binding.executePendingBindings()

        binding.imageViewBackground.load(tripItem.image) {
            crossfade(true)
        }
    }
}