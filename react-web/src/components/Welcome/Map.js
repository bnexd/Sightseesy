import React, { Component } from "react";
import tt from "@tomtom-international/web-sdk-maps";
import "@tomtom-international/web-sdk-services";
import "../../css/maps.css";

export default class Map extends Component {
    componentDidMount() {
        const map = tt.map({
            key: "NcxRyApajRzivcKOxPHN3d130zYT2BO7",
            style: "tomtom://vector/1/basic-main",
            container: "map"
        });
        map.addControl(new tt.FullscreenControl());
        map.addControl(new tt.NavigationControl());
        console.log(map);
    }

    render() {
        return (
            <div
                id="map"
                className="map"
                style={{ width: "100%", height: "500px" }}
            ></div>
        );
    }
}
