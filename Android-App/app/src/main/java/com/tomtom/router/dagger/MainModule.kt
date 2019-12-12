package com.tomtom.router.dagger

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.tomtom.router.data.TripRepository
import com.tomtom.router.ui.trips.TripViewModel
import com.tomtom.router.ui.trips.TripViewModelFactory
import dagger.Module
import dagger.Provides

@Module
abstract class MainModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun provideTripRepository(): TripRepository {
            return TripRepository.getInstance()
        }

        @JvmStatic
        @Provides
        fun provideTripViewModel(
            factory: TripViewModelFactory,
            activity: FragmentActivity
        ): TripViewModel = ViewModelProvider(activity, factory).get(TripViewModel::class.java)
    }
}