package com.tomtom.router.ui.trips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tomtom.router.data.trips.TripItem
import com.tomtom.router.data.trips.TripRepository
import com.tomtom.router.util.CoroutinesDispatcherProvider

class TripViewModel(
    tripRepository: TripRepository,
    dispatcherProvider: CoroutinesDispatcherProvider
) : ViewModel() {

    private val _tripItems = MutableLiveData<List<TripItem>>()
    val tripItems: LiveData<List<TripItem>>
        get() = _tripItems

    init {
        _tripItems.postValue(
            listOf(
                TripItem(
                    id = "-1",
                    city = "Berlin",
                    description = "Explore attractions like the Brandenburger Tor, TV tower and more.",
                    image = "https://www.tripsavvy.com/thmb/xKlcJhcoLlRKc23rBYwUWl8tCos=/950x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/berlin-622336554-5aca34cf6bf0690037ce00a3.jpg"
                ),
                TripItem(
                    id = "-2",
                    city = "Madrid",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    image = "https://www.cosmopolitan.de/bilder/610/2019/02/20/99560-eine-nacht-in-madrid-wir-verraten-euch-was-ihr-nicht-verpassen-duerft.jpg?itok=GXRyTK_e"
                ),
                TripItem(
                    id = "-3",
                    city = "Paris",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    image = "https://www.telegraph.co.uk/content/dam/Travel/hotels/europe/france/paris/paris-cityscape-overview-guide-xlarge.jpg"
                ),
                TripItem(
                    id = "-4",
                    city = "Amsterdam",
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    image = "https://www.travelbook.de/data/uploads/2018/10/gettyimages-923546342_1539616732-1040x690.jpg"
                )
            )
        )
    }
}