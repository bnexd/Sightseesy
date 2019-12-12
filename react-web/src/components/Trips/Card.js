import React, { Component } from "react";
import "./cardstyle.css";

export default class Card extends Component {
    render() {
        return (
            <>
                <div
                    class="blog-card spring-fever"
                    style={{
                        background:
                            "url(https://reise.naanoo.de/wp-content/uploads/2015/11/fernsehturm-berlin-331599182.jpg) center",
                        backgroundSize: "215%"
                    }}
                >
                    <div class="title-content">
                        <h3>BERLIN</h3>
                        <hr />
                    </div>
                    <div class="card-info">
                        Visit the TV Tower, Brandenburger Tor or Berlin Wall.
                    </div>
                    <div class="gradient-overlay"></div>
                    <div class="color-overlay"></div>
                </div>
            </>
        );
    }
}
