package com.tomtom.router.data.trips

import androidx.recyclerview.widget.DiffUtil

data class TripItem(
    val id: String,
    val city: String,
    val description: String,
    val image: String
)

object TripItemDiffCallback : DiffUtil.ItemCallback<TripItem>() {
    override fun areItemsTheSame(oldItem: TripItem, newItem: TripItem) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: TripItem, newItem: TripItem) = oldItem == newItem
}