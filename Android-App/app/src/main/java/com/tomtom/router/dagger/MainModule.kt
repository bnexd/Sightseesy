package com.tomtom.router.dagger

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.tomtom.router.data.api.RetrofitServiceBuilder
import com.tomtom.router.data.trips.TripRepository
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
        fun provideTripsRepository(): TripRepository {
            return TripRepository.getInstance(RetrofitServiceBuilder.tripService)
        }

        @JvmStatic
        @Provides
        fun provideTripsViewModel(
            factory: TripViewModelFactory,
            activity: FragmentActivity
        ): TripViewModel = ViewModelProvider(activity, factory).get(TripViewModel::class.java)
    }
}