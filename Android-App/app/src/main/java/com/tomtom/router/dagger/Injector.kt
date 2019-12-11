package com.tomtom.router.dagger

import com.tomtom.router.App
import com.tomtom.router.ui.trips.ExploreFragment
import com.tomtom.router.ui.trips.FavoritesFragment
import com.tomtom.router.ui.trips.ProfileFragment
import com.tomtom.router.ui.trips.TripsFragment

fun inject(fragment: TripsFragment) {
    App.appComponent(fragment.requireContext())
        .getMainComponentFactory()
        .create(fragment.requireActivity())
        .inject(fragment)
}

fun inject(fragment: FavoritesFragment) {
    App.appComponent(fragment.requireContext())
        .getMainComponentFactory()
        .create(fragment.requireActivity())
        .inject(fragment)
}

fun inject(fragment: ExploreFragment) {
    App.appComponent(fragment.requireContext())
        .getMainComponentFactory()
        .create(fragment.requireActivity())
        .inject(fragment)
}

fun inject(fragment: ProfileFragment) {
    App.appComponent(fragment.requireContext())
        .getMainComponentFactory()
        .create(fragment.requireActivity())
        .inject(fragment)
}