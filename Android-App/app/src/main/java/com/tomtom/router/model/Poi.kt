package com.tomtom.router.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.tomtom.online.sdk.common.location.LatLng
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Poi(
    val id: String,
    val name: String,
    val latLng: LatLng,
    val description: String,
    val image: String
) : Parcelable

object PoiDiffCallback : DiffUtil.ItemCallback<Poi>() {
    override fun areItemsTheSame(oldItem: Poi, newItem: Poi) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Poi, newItem: Poi) = oldItem == newItem
}