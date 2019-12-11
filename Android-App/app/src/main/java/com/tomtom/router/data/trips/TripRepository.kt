package com.tomtom.router.data.trips

import com.tomtom.router.data.Result
import com.tomtom.router.data.TripDao
import com.tomtom.router.data.api.TripService

class TripRepository private constructor(private val tripService: TripService) : TripDao {

    companion object {

        @Volatile private var instance: TripRepository? = null

        fun getInstance(tripService: TripService) =
            instance ?: TripRepository(tripService).also { instance = it }
    }

    override suspend fun getTripByCityId(id: String): Result<List<Trip>> {
        // ...
        return Result.Success(emptyList())
    }
}