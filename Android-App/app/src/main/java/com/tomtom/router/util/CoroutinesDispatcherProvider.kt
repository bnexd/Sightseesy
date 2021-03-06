package com.tomtom.router.util

import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.rx2.asCoroutineDispatcher
import javax.inject.Inject

data class CoroutinesDispatcherProvider(
    val main: CoroutineDispatcher,
    val disk: CoroutineDispatcher,
    val network: CoroutineDispatcher,
    val database: CoroutineDispatcher
) {
    @Inject
    constructor() : this(
        main = Dispatchers.Main,
        disk = Dispatchers.IO,
        network = Dispatchers.IO,
        database = Schedulers.single().asCoroutineDispatcher()
    )
}