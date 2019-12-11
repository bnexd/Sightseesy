package com.tomtom.router.dagger

import com.tomtom.router.App
import com.tomtom.router.ui.trips.TripFragment

fun inject(fragment: TripFragment) {
    App.appComponent(fragment.requireContext())
        .getMainComponentFactory()
        .create(fragment.requireActivity())
        .inject(fragment)
}