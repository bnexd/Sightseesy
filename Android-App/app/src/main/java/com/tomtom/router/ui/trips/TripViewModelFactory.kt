package com.tomtom.router.ui.trips

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tomtom.router.data.TripRepository
import javax.inject.Inject

class TripViewModelFactory @Inject constructor(
    private val repository: TripRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TripViewModel(repository) as T
    }
}