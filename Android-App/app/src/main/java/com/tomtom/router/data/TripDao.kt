package com.tomtom.router.data

import com.tomtom.router.model.TripItem

interface TripDao {
    suspend fun getTripByCityId(id: String): Result<List<TripItem>>
}