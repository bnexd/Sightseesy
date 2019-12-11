import React from "react";
import app from "../../firebase";

const Header = () => {
    const user = app.auth().currentUser;
    return (
        <nav
            className="navbar navbar-light navbar-expand-md navigation-clean-search"
            style={{ backgroundColor: "rgb(255,255,255)" }}
        >
            <div className="container">
                <a
                    className="navbar-brand"
                    href="/"
                    style={{ color: "rgb(244,0,96)" }}
                >
                    Sightseesy
                </a>
                <button
                    data-toggle="collapse"
                    className="navbar-toggler"
                    data-target="#navcol-1"
                >
                    <span className="sr-only">Toggle navigation</span>
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navcol-1">
                    <ul className="nav navbar-nav">
                        <li className="nav-item" role="presentation">
                            <a
                                className="nav-link"
                                href="/locations"
                                style={{ color: "rgb(143,143,143)" }}
                            >
                                Locations
                            </a>
                        </li>
                        <li className="nav-item" role="presentation">
                            <a
                                className="nav-link"
                                href="/trips"
                                style={{ color: "rgb(143,143,143)" }}
                            >
                                Trips
                            </a>
                        </li>
                        <li className="nav-item" role="presentation"></li>
                    </ul>
                    <form className="form-inline mr-auto" target="_self"></form>
                    <div className="dropdown">
                        <p>Demo Account</p>
                    </div>
                </div>
            </div>
        </nav>
    );
};

export default Header;
