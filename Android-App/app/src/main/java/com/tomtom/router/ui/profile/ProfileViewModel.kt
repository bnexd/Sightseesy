package com.tomtom.router.ui.trips

import androidx.lifecycle.ViewModel
import com.tomtom.router.data.trips.TripRepository
import com.tomtom.router.util.CoroutinesDispatcherProvider

class ProfileViewModel(
    tripRepository: TripRepository,
    dispatcherProvider: CoroutinesDispatcherProvider
) : ViewModel() {

    init {
    }
}