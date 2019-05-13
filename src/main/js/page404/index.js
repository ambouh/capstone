import React, { Component } from 'react';
import {Link, withRouter} from 'react-router-dom';

class index extends Component {
    title = "Page 404";
    logoutDiv = {marginTop: "20px", marginLeft: "70px"};
    render() {
        return (
            <div className="templateDiv" style={this.logoutDiv}>
                <h1 className={"templateTitle"}>{this.title}</h1>
                <p className={"templateText"}>You're lost buddy. Go on, return home.</p>

                <Link to={"/"} className={"forBtn"}> Return home > </Link>
            </div>
        );
    }
}

export default withRouter(index);