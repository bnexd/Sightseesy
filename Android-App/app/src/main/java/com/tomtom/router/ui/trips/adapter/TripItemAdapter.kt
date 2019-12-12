package com.tomtom.router.ui.trips.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.tomtom.router.databinding.ViewholderTripBinding
import com.tomtom.router.model.TripItem
import com.tomtom.router.model.TripItemDiffCallback

class TripItemAdapter(private val listener: TripItemClickListener) :
    ListAdapter<TripItem, TripItemViewHolder>(
        TripItemDiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ViewholderTripBinding.inflate(layoutInflater, parent, false)
        return TripItemViewHolder(binding)
    }

    fun getTripItemAt(position: Int): TripItem = getItem(position)

    override fun onBindViewHolder(holder: TripItemViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    interface TripItemClickListener {
        fun onTripItemClicked(tripItem: TripItem)
    }
}