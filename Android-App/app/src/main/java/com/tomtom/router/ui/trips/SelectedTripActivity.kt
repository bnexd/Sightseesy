package com.tomtom.router.ui.trips

import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.tomtom.online.sdk.common.location.LatLng
import com.tomtom.online.sdk.map.*
import com.tomtom.online.sdk.routing.OnlineRoutingApi
import com.tomtom.online.sdk.routing.RoutingApi
import com.tomtom.online.sdk.routing.data.*
import com.tomtom.online.sdk.search.OnlineSearchApi
import com.tomtom.online.sdk.search.SearchApi
import com.tomtom.online.sdk.search.data.reversegeocoder.ReverseGeocoderSearchQueryBuilder
import com.tomtom.online.sdk.search.data.reversegeocoder.ReverseGeocoderSearchResponse
import com.tomtom.router.R
import com.tomtom.router.dagger.inject
import com.tomtom.router.databinding.ActivitySelectedTripBinding
import com.tomtom.router.model.Poi
import com.tomtom.router.model.TripItem
import com.tomtom.router.ui.ScopedActivity
import com.tomtom.router.ui.trips.adapter.PoiAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class SelectedTripActivity : ScopedActivity(), OnMapReadyCallback,
    TomtomMapCallback.OnMapLongClickListener, PoiAdapter.PoiClickListener {

    @Inject
    private lateinit var tripViewModel: TripViewModel

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private val args: SelectedTripActivityArgs by navArgs()
    private lateinit var binding: ActivitySelectedTripBinding

    private lateinit var map: TomtomMap

    private lateinit var searchApi: SearchApi
    private lateinit var routingApi: RoutingApi
    private lateinit var departureIcon: Icon
    private lateinit var destinationIcon: Icon

    private var route: Route? = null
    private var departurePosition: LatLng? = null
    private var destinationPosition: LatLng? = null
    private var wayPointPosition: LatLng? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_selected_trip)

        setupMap()
        setupRoute()
        loadData()
    }

    private fun loadData() {
        binding.trip = args.tripItem
        setupPoiAdapter(args.tripItem, this)
    }

    private fun setupRoute() {
        searchApi = OnlineSearchApi.create(this)
        routingApi = OnlineRoutingApi.create(this)

        departureIcon = Icon.Factory.fromResources(this, R.drawable.ic_map_route_departure)
        destinationIcon = Icon.Factory.fromResources(this, R.drawable.ic_map_route_destination)
    }

    private fun setupMap() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.mapFragment) as MapFragment
        mapFragment.getAsyncMap(this)
    }

    override fun onMapReady(tomtomMap: TomtomMap) {
        map = tomtomMap

        val mapPaddingVertical = resources.getDimension(R.dimen.margin_small).toDouble()
        val mapPaddingHorizontal = resources.getDimension(R.dimen.margin_small).toDouble()

        map.isMyLocationEnabled = true
        map.uiSettings.currentLocationView.hide()
        map.addOnMapLongClickListener(this)
        map.markerSettings.setMarkersClustering(true)

        map.centerOn(CameraPosition.builder(args.tripItem.cityPosition.toLatLng()).zoom(7.0).build())
        map.markerSettings.markerBalloonViewAdapter = createCustomViewAdapter()

        map.setPadding(
            mapPaddingVertical, mapPaddingHorizontal,
            mapPaddingVertical, mapPaddingHorizontal
        )

        val markers = arrayListOf<LatLng>()
        args.tripItem.pois.forEach {
            createMarkerIfNotPresent(it.position.toLatLng(), null)
            markers.add(it.position.toLatLng())
        }
        drawRoute(markers)
    }

    private fun drawRoute(markers: List<LatLng>) {

        var currentPos: LatLng? = null
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                if (location != null) {
                    currentPos = LatLng(location.latitude, location.longitude)
                }
            }

        val array = markers.toTypedArray()
        drawRouteWithWayPoints(
            start = currentPos ?: array[0],
            stop = currentPos ?: array[0],
            wayPoints = array
        )
    }

    override fun onMapLongClick(latLng: LatLng) {
        if (isDeparturePositionSet() && isDestinationPositionSet()) {
            clearMap()
        } else {
            handleLongClick(latLng)
        }
    }

    private fun handleLongClick(latLng: LatLng) {
        searchApi.reverseGeocoding(
            ReverseGeocoderSearchQueryBuilder(
                latLng.latitude,
                latLng.longitude
            ).build()
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<ReverseGeocoderSearchResponse?>() {
                override fun onSuccess(response: ReverseGeocoderSearchResponse) {
                    processResponse(response)
                }

                override fun onError(e: Throwable) {
                    handleApiError(e)
                }

                private fun processResponse(response: ReverseGeocoderSearchResponse) {
                    if (response.hasResults()) {
                        processFirstResult(response.addresses[0].position)
                    } else {
                        Toast.makeText(
                            this@SelectedTripActivity,
                            getString(R.string.geocode_no_results),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                private fun processFirstResult(geocodedPosition: LatLng) {
                    if (!isDeparturePositionSet()) {
                        setAndDisplayDeparturePosition(geocodedPosition)
                    } else {
                        destinationPosition = geocodedPosition
                        map.removeMarkers()
                        drawRoute(departurePosition!!, destinationPosition!!)
                    }
                }

                private fun setAndDisplayDeparturePosition(geocodedPosition: LatLng) {
                    departurePosition = geocodedPosition
                    createMarkerIfNotPresent(departurePosition!!, departureIcon)
                }
            })
    }

    private fun createMarkerIfNotPresent(position: LatLng, icon: Icon?) {
        if (icon != null) {
            map.addMarker(MarkerBuilder(position).icon(icon))
        } else {
            map.addMarker(MarkerBuilder(position).icon(null))
        }
    }


    private fun isDestinationPositionSet(): Boolean {
        return destinationPosition != null
    }


    private fun isDeparturePositionSet(): Boolean {
        return departurePosition != null
    }

    private fun drawRoute(start: LatLng, stop: LatLng) {
        wayPointPosition = null
        drawRouteWithWayPoints(start, stop, null)
    }

    private fun drawRouteWithWayPoints(
        start: LatLng,
        stop: LatLng,
        wayPoints: Array<LatLng>?
    ) {
        val routeQuery = createRouteQuery(start, stop, wayPoints)
        routingApi.planRoute(routeQuery)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<RouteResponse?>() {
                override fun onSuccess(routeResponse: RouteResponse) {
                    displayRoutes(routeResponse.routes)
                    map.displayRoutesOverview()
                }

                private fun displayRoutes(routes: List<FullRoute>) {
                    for (fullRoute in routes) {
                        route = map.addRoute(
                            RouteBuilder(
                                fullRoute.coordinates
                            ).startIcon(departureIcon).endIcon(destinationIcon)
                        )
                    }
                }

                override fun onError(e: Throwable) {
                    handleApiError(e)
                    clearMap()
                }
            })
    }

    private fun createCustomViewAdapter(): SingleLayoutBalloonViewAdapter? {
        return object : SingleLayoutBalloonViewAdapter(R.layout.marker_custom_balloon) {
            override fun onBindView(
                view: View,
                marker: Marker,
                baseMarkerBalloon: BaseMarkerBalloon
            ) {
                val btnAddWayPoint: Button = view.findViewById(R.id.btn_balloon_waypoint)
                val textViewPoiName: TextView =
                    view.findViewById(R.id.textview_balloon_poiname)
                val textViewPoiAddress: TextView =
                    view.findViewById(R.id.textview_balloon_poiaddress)
                textViewPoiName.text = baseMarkerBalloon.getStringProperty(
                    applicationContext.getString(
                        R.string.poi_name_key
                    )
                )
                textViewPoiAddress.text = baseMarkerBalloon.getStringProperty(
                    applicationContext.getString(
                        R.string.address_key
                    )
                )
                btnAddWayPoint.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View?) {
                        setWayPoint(marker)
                    }

                    private fun setWayPoint(marker: Marker) {
                        wayPointPosition = marker.position
                        map.clearRoute()
                        drawRouteWithWayPoints(
                            departurePosition!!,
                            destinationPosition!!,
                            arrayOf(wayPointPosition!!)
                        )
                        marker.deselect()
                    }
                })
            }
        }
    }

    private fun createRouteQuery(
        start: LatLng,
        stop: LatLng,
        wayPoints: Array<LatLng>?
    ): RouteQuery? {
        return if (wayPoints != null) RouteQueryBuilder(
            start,
            stop
        ).withWayPoints(wayPoints).withRouteType(RouteType.FASTEST).build() else RouteQueryBuilder(
            start,
            stop
        ).withRouteType(RouteType.FASTEST).build()
    }

    private fun clearMap() {
        map.clear()
        departurePosition = null
        destinationPosition = null
        route = null
    }

    private fun handleApiError(e: Throwable) {
        Toast.makeText(
            this@SelectedTripActivity,
            getString(R.string.api_response_error, e.localizedMessage),
            Toast.LENGTH_LONG
        ).show()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        map.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    private fun setupPoiAdapter(tripItem: TripItem, listener: PoiAdapter.PoiClickListener) {
        val viewManager = LinearLayoutManager(this)
        val viewAdapter = PoiAdapter(listener)

        binding.recyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewAdapter.submitList(tripItem.pois)
    }

    override fun onPoiClicked(poi: Poi) {
        Toast.makeText(this, poi.name, Toast.LENGTH_LONG).show()

        map.centerOn(CameraPosition.builder(poi.position.toLatLng()).zoom(16.0).build())
        map.markerSettings.markerBalloonViewAdapter = createCustomViewAdapter()
    }
}
