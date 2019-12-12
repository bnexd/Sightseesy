import React, { useCallback, useState } from "react";
import "rc-time-picker/assets/index.css";
import moment from "moment";
import TimePicker from "rc-time-picker";
import axios from "axios";
import Map from "./Map";
import "bootstrap/dist/css/bootstrap.min.css";

const Search = () => {
    const [markers, setMarkers] = useState("");
    const handleSearch = useCallback(async event => {
        event.preventDefault();
        const { cityName, startDate, endDate } = event.target.elements;
        if (cityName.value !== "") {
            try {
                axios
                    .post(
                        "https://dcvvov37id.execute-api.us-east-1.amazonaws.com/latest/points",
                        {
                            name: cityName.value,
                            startDate: startDate.value,
                            endDate: endDate.value,
                            categories: "family"
                        }
                    )
                    .then(res => {
                        console.log(res);
                        console.log(res.data);
                        setMarkers({
                            m1: {
                                name: "TV Tower",
                                lat: "52.520652",
                                lon: "13.409162"
                            },
                            m2: {
                                name: "Berlin Wall",
                                lon: "13.383763",
                                lat: "52.507276"
                            },
                            m3: {
                                name: "Reichstagsgebäude",
                                lon: "13.375955",
                                lat: "52.518126"
                            }
                        });
                    });
            } catch (error) {
                alert(error);
            }
        } else {
            alert("Pls fill in a city name");
        }
    }, []);

    return (
        <>
            <div
                style={{
                    margin: "auto",
                    width: "50%",
                    padding: "10px"
                }}
            >
                <form onSubmit={handleSearch}>
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
                            name="cityName"
                            placeholder="Give me a city"
                            aria-label="Search"
                            style={{
                                display: "block"
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
                            name="startDate"
                            defaultValue={moment()}
                            showSecond={false}
                            minuteStep={10}
                            style={{ marginRight: "5px" }}
                        />
                        <TimePicker
                            id="endDate"
                            name="endDate"
                            defaultValue={moment()}
                            showSecond={false}
                            minuteStep={10}
                            style={{ float: "right" }}
                        />
                        <button
                            type="submit"
                            className="btn btn-dark"
                            style={{
                                marginTop: "10px",
                                float: "right",
                                marginBottom: "10px"
                            }}
                        >
                            Search
                        </button>
                    </div>
                </form>
            </div>
            <Map markers={markers} />
        </>
    );
};

export default Search;
