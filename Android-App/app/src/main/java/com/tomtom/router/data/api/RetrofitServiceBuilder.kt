package com.tomtom.router.data.api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitServiceBuilder {

    private const val BASE_URL = "https://dcvvov37id.execute-api.us-east-1.amazonaws.com/latest/"

    private val builder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }

    val tripService: TripService by lazy {
        builder
            .build()
            .create(TripService::class.java)
    }
}