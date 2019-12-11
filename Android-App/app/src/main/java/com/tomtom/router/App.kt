package com.tomtom.router

import android.app.Application
import android.content.Context
import com.google.firebase.FirebaseApp
import com.jakewharton.threetenabp.AndroidThreeTen
import com.tomtom.router.dagger.AppComponent
import com.tomtom.router.dagger.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .factory()
            .create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        AndroidThreeTen.init(this)
    }

    companion object {
        @JvmStatic
        fun appComponent(context: Context): AppComponent {
            return (context.applicationContext as App).appComponent
        }
    }

}