package com.tomtom.router.data

import com.tomtom.router.data.api.TripService
import com.tomtom.router.model.TripItem
import java.io.IOException

class TripRepository private constructor(
    private val service: TripService
) {
    companion object {

        @Volatile private var instance: TripRepository? = null

        fun getInstance(service: TripService) =
            instance ?: TripRepository(service).also { instance = it }
    }

    suspend fun getTrip(city: String): Result<TripItem> {
        return try {
            val response = service.getTrip(city)
            getResult(response = response, onError = {
                throw IOException("Error getting feed by user: ${response.code()} ${response.message()}")
            })
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}