import React, { Component } from "react";
import "rc-time-picker/assets/index.css";
import moment from "moment";
import TimePicker from "rc-time-picker";

export default class Search extends Component {
    render() {
        return (
            <>
                <div
                    style={{
                        margin: "auto",
                        width: "50%",
                        padding: "10px"
                    }}
                >
                    <form onSubmit={console.log("Lulw")}>
                        <div
                            style={{
                                margin: "auto",
                                width: "50%",
                                padding: "10px"
                            }}
                        >
                            <input
                                className="form-control"
                                type="text"
                                placeholder="Give me a city"
                                aria-label="Search"
                                style={{
                                    display: "block",
                                    marginBottom: "10px"
                                }}
                            />
                        </div>
                        <div
                            id="timepickers"
                            style={{
                                margin: "auto",
                                width: "50%",
                                padding: "10px"
                            }}
                        >
                            <TimePicker
                                id="startDate"
                                defaultValue={moment()}
                                showSecond={false}
                                minuteStep={10}
                                style={{ marginRight: "5px" }}
                            />
                            <TimePicker
                                id="endDate"
                                defaultValue={moment()}
                                showSecond={false}
                                minuteStep={10}
                                style={{ float: "right" }}
                            />
                            <div
                                style={{
                                    margin: "auto",
                                    width: "50%",
                                    padding: "10px",
                                    textAlign: "center"
                                }}
                            >
                                <button
                                    type="submit"
                                    className="btn btn-dark"
                                    style={{ marginLeft: "5px" }}
                                >
                                    Search
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </>
        );
    }
}
