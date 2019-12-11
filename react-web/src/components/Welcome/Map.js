import React, { Component } from "react";
import tt from "@tomtom-international/web-sdk-maps";
import "@tomtom-international/web-sdk-services";
import "../../css/maps.css";

export default class Map extends Component {
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
