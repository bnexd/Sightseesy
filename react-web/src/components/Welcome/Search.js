import React, { Component } from "react";

export default class Search extends Component {
    render() {
        return (
            <div style={{ width: "400px" }}>
                <input
                    class="form-control"
                    type="text"
                    placeholder="Search"
                    aria-label="Search"
                    onSubmit={console.log("Hi")}
                />
            </div>
        );
    }
}
