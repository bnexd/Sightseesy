package com.tomtom.router.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tomtom.router.data.api.Position
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Poi(

    @Json(name = "id")
    val id: String,

    @Json(name = "name")
    val name: String,

    @Json(name = "position")
    val position: Position,

    @Json(name = "description")
    val description: String,

    @Json(name = "image")
    val image: String?
) : Parcelable

object PoiDiffCallback : DiffUtil.ItemCallback<Poi>() {
    override fun areItemsTheSame(oldItem: Poi, newItem: Poi) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Poi, newItem: Poi) = oldItem == newItem
}