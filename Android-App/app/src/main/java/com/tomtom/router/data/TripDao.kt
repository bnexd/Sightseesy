package com.tomtom.router.data

import com.tomtom.router.data.trips.TripItem

interface TripDao {
    suspend fun getTripByCityId(id: String): Result<List<TripItem>>
}