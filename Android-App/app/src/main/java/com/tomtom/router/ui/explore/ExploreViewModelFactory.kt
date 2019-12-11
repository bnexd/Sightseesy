package com.tomtom.router.ui.trips

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomtom.router.data.trips.TripRepository
import com.tomtom.router.util.CoroutinesDispatcherProvider
import javax.inject.Inject

class ExploreViewModelFactory @Inject constructor(
    private val repository: TripRepository,
    private val dispatcherProvider: CoroutinesDispatcherProvider
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExploreViewModel(repository, dispatcherProvider) as T
    }
}