package com.tomtom.router.dagger

import com.tomtom.router.App
import com.tomtom.router.ui.trips.TripsFragment

fun inject(fragment: TripsFragment) {
    App.appComponent(fragment.requireContext())
        .getMainComponentFactory()
        .create(fragment.requireActivity())
        .inject(fragment)
}