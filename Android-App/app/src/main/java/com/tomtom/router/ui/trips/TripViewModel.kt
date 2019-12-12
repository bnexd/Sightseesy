package com.tomtom.router.ui.trips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tomtom.online.sdk.common.location.LatLng
import com.tomtom.router.data.trips.TripRepository
import com.tomtom.router.model.Poi
import com.tomtom.router.model.TripItem
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
                    cityLatLng = LatLng(52.50, 13.38),
                    description = "Explore pois like the Brandenburger Tor, TV tower and more.",
                    image = "https://www.tripsavvy.com/thmb/xKlcJhcoLlRKc23rBYwUWl8tCos=/950x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/berlin-622336554-5aca34cf6bf0690037ce00a3.jpg",
                    pois = listOf(
                        Poi(
                            id = "-1",
                            name = "Brandenburger Tor",
                            latLng = LatLng(52.516266, 13.377775),
                            description = "Lorem ipsum",
                            image = " "
                        ),
                        Poi(
                            id = "-2",
                            name = "TV Tower",
                            latLng = LatLng(52.520817, 13.409419),
                            description = "Lorem ipsum",
                            image = " "
                        )
                    )
                ),
                TripItem(
                    id = "-2",
                    city = "Madrid",
                    cityLatLng = LatLng(52.37, 4.90),
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    image = "https://www.cosmopolitan.de/bilder/610/2019/02/20/99560-eine-nacht-in-madrid-wir-verraten-euch-was-ihr-nicht-verpassen-duerft.jpg?itok=GXRyTK_e",
                    pois = listOf(
                        Poi(
                            id = "-1",
                            name = "Brandenburger Tor",
                            latLng = LatLng(50.0, 50.0),
                            description = "Lorem ipsum",
                            image = " "
                        )
                    )
                ),
                TripItem(
                    id = "-3",
                    city = "Paris",
                    cityLatLng = LatLng(52.37, 4.90),
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    image = "https://www.telegraph.co.uk/content/dam/Travel/hotels/europe/france/paris/paris-cityscape-overview-guide-xlarge.jpg",
                    pois = listOf(
                        Poi(
                            id = "-1",
                            name = "Brandenburger Tor",
                            latLng = LatLng(50.0, 50.0),
                            description = "Lorem ipsum",
                            image = " "
                        )
                    )
                ),
                TripItem(
                    id = "-4",
                    city = "Amsterdam",
                    cityLatLng = LatLng(52.37, 4.90),
                    description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                    image = "https://www.travelbook.de/data/uploads/2018/10/gettyimages-923546342_1539616732-1040x690.jpg",
                    pois = listOf(
                        Poi(
                            id = "-1",
                            name = "Brandenburger Tor",
                            latLng = LatLng(50.0, 50.0),
                            description = "Lorem ipsum",
                            image = " "
                        )
                    )
                )
            )
        )
    }
}