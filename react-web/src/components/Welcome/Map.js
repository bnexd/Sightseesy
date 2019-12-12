import React, { Component } from "react";
import tt from "@tomtom-international/web-sdk-maps";
import tomtom from "@tomtom-international/web-sdk-services";
import "../../css/maps.css";
export default class Map extends Component {
    constructor(props) {
        super(props);
        this.state = this.props.markers;
    }
    componentDidMount() {
        var centerLocation = new tt.LngLat(13.452986, 52.496491);
        //eslint-disable-next-line
        const map = tt.map({
            key: "NcxRyApajRzivcKOxPHN3d130zYT2BO7",
            style: "tomtom://vector/1/basic-main/6",
            zoom: 9,
            center: centerLocation,
            container: "map"
        });
    }
    componentDidUpdate(props) {
        document.getElementById("map").style.filter = "";
        var centerLocation = new tt.LngLat(13.452986, 52.496491);
        //eslint-disable-next-line
        const map = tt.map({
            key: "NcxRyApajRzivcKOxPHN3d130zYT2BO7",
            style: "tomtom://vector/1/basic-main/6",
            zoom: 10,
            center: centerLocation,
            container: "map"
        });
        const { markers } = this.props;
        Object.keys(markers).map(key => {
            var marker = markers[key];
            console.log(marker);
            marker = new tt.Marker()
                .setLngLat([marker.lon, marker.lat])
                .addTo(map);
            marker.setPopup(new tt.Popup().setHTML("Fernsehturm"));
        });

        /*
        tomtom.services
            .calculateRoute({
                key: "NcxRyApajRzivcKOxPHN3d130zYT2BO7",
                locations: [],

                computeBestOrder: true
            })
            .go()
            .then(function(response) {
                var geojson = response.toGeoJson();
                map.addLayer({
                    id: "route",
                    type: "line",
                    source: {
                        type: "geojson",
                        data: geojson
                    },
                    paint: {
                        "line-color": "rgb(244, 0, 96)",
                        "line-width": 4
                    }
                });
                var bounds = new tt.LngLatBounds();
                geojson.features[0].geometry.coordinates.forEach(function(
                    point
                ) {
                    bounds.extend(tt.LngLat.convert(point));
                });
                map.fitBounds(bounds, { padding: 20 });
            });
            */
    }

    render() {
        return (
            <div
                id="map"
                className="map"
                style={{
                    width: "100%",
                    height: "400px",
                    filter: "grayscale(100%)"
                }}
            ></div>
        );
    }
}
