package com.tomtom.router.data.api

import com.tomtom.router.model.TripItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TripService {

    @GET("trips/{city}")
    suspend fun getTrip(
        @Path("city") city: String
    ): Response<TripItem>

}