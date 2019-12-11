package com.tomtom.router.data.api

import com.tomtom.router.data.trips.Trip
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface TripService {

    @GET("/")
    suspend fun getAllTellsBySender(
        @Path("id") id: String
    ): Response<List<Trip>>

}