import React from "react";
import "./App.css";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import "./css/Registration-Form-with-Photo.css";
import "./css/Navigation-with-Search.css";
import "./css/styles.css";
import Search from "./components/Welcome/Search";
import Map from "./components/Welcome/Map";

function App() {
    return (
        <>
            <Header />

            <Search />
            <Map />
        </>
    );
}

export default App;
