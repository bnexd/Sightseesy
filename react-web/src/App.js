import React from "react";
import "./App.css";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import "./css/Registration-Form-with-Photo.css";
import "./css/Navigation-with-Search.css";
import "./css/styles.css";
import Footer from "./components/Layout/Footer";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Result from "./components/Result/Result";
import Index from "./components/Welcome/Index";
import Trips from "./components/Trips/Trips";

function App() {
    return (
        <>
            <Header />
            <Router>
                <Route exact path="/" component={Index} />
                <Route exact path="/result" component={Result} />
                <Route exact path="/trips" component={Trips} />
            </Router>
            <Footer />
        </>
    );
}

export default App;
