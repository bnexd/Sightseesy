package com.tomtom.router.data.api

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.tomtom.online.sdk.common.location.LatLng
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Position(
    @Json(name = "latitude")
    val lat: Double,

    @Json(name = "longitude")
    val lng: Double
) : Parcelable {
    fun toLatLng() = LatLng(lat, lng)
}