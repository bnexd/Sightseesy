package com.tomtom.router.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.tomtom.online.sdk.common.location.LatLng
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TripItem(
    val id: String,
    val city: String,
    val cityLatLng: LatLng,
    val description: String,
    val image: String,
    val pois: List<Poi>
) : Parcelable

object TripItemDiffCallback : DiffUtil.ItemCallback<TripItem>() {
    override fun areItemsTheSame(oldItem: TripItem, newItem: TripItem) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: TripItem, newItem: TripItem) = oldItem == newItem
}