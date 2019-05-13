import React, { Component } from 'react';
import {Link, withRouter} from 'react-router-dom';

class Logout extends Component {
    title = "Log Out";
    logoutDiv = {marginTop: "20px", marginLeft: "70px"};
    render() {
        return (
            <div className="templateDiv" style={this.logoutDiv}>
                <h1 className={"templateTitle"}>{this.title}</h1>
                <p className={"templateText"}>You have logged out successfully! Good bye.</p>

                <Link to={"/"} className={"forBtn"}> Return home > </Link>
            </div>
        );
    }
}

export default withRouter(Logout);