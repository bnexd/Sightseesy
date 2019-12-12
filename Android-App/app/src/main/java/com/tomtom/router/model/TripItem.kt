package com.tomtom.router.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tomtom.router.data.api.Position
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class TripItem(

    @Json(name = "id")
    val id: String,

    @Json(name = "city")
    val city: String,

    @Json(name = "cityLatLng")
    val cityPosition: Position,

    @Json(name = "description")
    val description: String,

    @Json(name = "image")
    val image: String,

    @Json(name = "pois")
    val pois: List<Poi>
) : Parcelable

object TripItemDiffCallback : DiffUtil.ItemCallback<TripItem>() {
    override fun areItemsTheSame(oldItem: TripItem, newItem: TripItem) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: TripItem, newItem: TripItem) = oldItem == newItem
}