package com.tomtom.router.data.trips

import com.tomtom.router.data.Result
import com.tomtom.router.data.TripDao

class TripRepository private constructor() : TripDao {

    companion object {

        @Volatile private var instance: TripRepository? = null

        fun getInstance() =
            instance ?: TripRepository().also { instance = it }
    }

    override suspend fun getTripByCityId(id: String): Result<List<TripItem>> {
        // ...
        return Result.Success(emptyList())
    }
}