package com.tomtom.router.dagger

import androidx.fragment.app.FragmentActivity
import com.tomtom.router.ui.trips.TripFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance activity: FragmentActivity): MainComponent
    }

    fun inject(target: TripFragment)
}