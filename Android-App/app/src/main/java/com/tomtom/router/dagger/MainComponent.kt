package com.tomtom.router.dagger

import androidx.fragment.app.FragmentActivity
import com.tomtom.router.ui.trips.TripsFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: FragmentActivity): MainComponent
    }

    fun inject(target: TripsFragment)
}