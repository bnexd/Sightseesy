package com.tomtom.router

object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.1"

    object Google {
        const val material = "com.google.android.material:material:1.1.0-beta01"
        const val gmsGoogleServices = "com.google.gms:google-services:4.3.2"

        object Firebase {
            const val analytics = "com.google.firebase:firebase-analytics:17.2.0"
            const val auth = "com.google.firebase:firebase-auth:19.1.0"
        }

        object Dagger {
            private const val version = "2.25.2"
            const val dagger = "com.google.dagger:dagger:$version"
            const val compiler = "com.google.dagger:dagger-compiler:$version"
        }
    }

    object Kotlin {
        private const val version = "1.3.61"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"
        const val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"
        const val extensions = "org.jetbrains.kotlin:kotlin-android-extensions:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.3.2"
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
            const val reactive = "org.jetbrains.kotlinx:kotlinx-coroutines-reactive:$version"
            const val rx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:$version"
        }
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.1.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta3"
        const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0-beta05"
        const val swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:1.0.0"

        object Navigation {
            private const val version = "2.2.0-rc01"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$version"
            const val runtime = "androidx.navigation:navigation-runtime-ktx:$version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$version"
            const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:$version"
        }

        object Fragment {
            private const val version = "1.2.0-beta01"
            const val fragment = "androidx.fragment:fragment:$version"
            const val fragmentKtx = "androidx.fragment:fragment-ktx:$version"
        }

        object Lifecycle {
            private const val version = "2.2.0-beta01"
            const val runtime = "androidx.lifecycle:lifecycle-runtime:$version"
            const val compiler = "androidx.lifecycle:lifecycle-compiler:$version"
            const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:$version"
        }

        object Room {
            private const val version = "2.2.1"
            const val runtime = "androidx.room:room-runtime:$version"
            const val compiler = "androidx.room:room-compiler:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val testing = "androidx.room:room-testing:$version"
        }

        object Test {
            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
            const val junitExt = "androidx.test.ext:junit:1.1.1"
            const val junitRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    object Square {

        object Moshi {
            private const val version = "1.9.1"
            const val moshi = "com.squareup.moshi:moshi-kotlin:$version"
            const val codegen = "com.squareup.moshi:moshi-kotlin-codegen:$version"
        }

        object Retrofit {
            private const val version = "2.6.1"
            const val retrofit = "com.squareup.retrofit2:retrofit:$version"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:$version"
            const val scalars = "com.squareup.retrofit2:converter-scalars:$version"
        }

        object OkHttp {
            private const val version = "4.2.1"
            const val okHttp = "com.squareup.okhttp3:okhttp:$version"
            const val logging = "com.squareup.okhttp3:logging-interceptor:$version"
        }
    }

    object TomTom {
        private const val version = "2.4340"
        const val sdk = "com.tomtom.online:sdk-maps:$version"
    }

    object ReactiveX {
        const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.15"
        const val rxAndroid = "io.reactivex.rxjava2:rxjava:2.1.1"
        const val rxBinding = "com.jakewharton.rxbinding2:rxbinding:2.2.0"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    }

    object Coil {
        private const val version = "0.8.0"
        const val coil = "io.coil-kt:coil:$version"
    }

    object ThreeTen {
        const val threeTen = "com.jakewharton.threetenabp:threetenabp:1.2.1"
    }

    object Test {
        const val junit = "junit:junit:4.12"
    }
}