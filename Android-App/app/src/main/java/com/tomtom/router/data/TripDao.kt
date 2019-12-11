package com.tomtom.router.data

import com.tomtom.router.data.trips.Trip

interface TripDao {
    suspend fun getTripByCityId(id: String): Result<List<Trip>>
}