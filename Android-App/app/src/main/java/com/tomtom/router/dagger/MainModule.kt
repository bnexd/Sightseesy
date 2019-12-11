package com.tomtom.router.dagger

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.tomtom.router.data.trips.TripRepository
import com.tomtom.router.ui.trips.*
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

        @JvmStatic
        @Provides
        fun provideFavoritesViewModel(
            factory: FavoritesViewModelFactory,
            activity: FragmentActivity
        ): FavoritesViewModel =
            ViewModelProvider(activity, factory).get(FavoritesViewModel::class.java)

        @JvmStatic
        @Provides
        fun provideExploreViewModel(
            factory: ExploreViewModelFactory,
            activity: FragmentActivity
        ): ExploreViewModel = ViewModelProvider(activity, factory).get(ExploreViewModel::class.java)

        @JvmStatic
        @Provides
        fun provideProfileViewModel(
            factory: ProfileViewModelFactory,
            activity: FragmentActivity
        ): ProfileViewModel = ViewModelProvider(activity, factory).get(ProfileViewModel::class.java)
    }
}