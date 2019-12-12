import React, { Component } from "react";
import Card from "./Card";

export default class Trips extends Component {
    render() {
        return (
            <>
                <div>
                    <h2 style={{ textAlign: "center" }}>Trips</h2>
                </div>
                <div>
                    <Card />
                </div>
            </>
        );
    }
}
