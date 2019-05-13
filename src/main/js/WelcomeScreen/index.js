import React, { Component } from 'react';
import {Route, Switch} from "react-router-dom";
import Login from "../Login";
import ProtectedRoute from '../protected.route';
import Dashboard from "../Dashboard";

class WelcomeScreen extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={Login}/>
                <ProtectedRoute path="/dashboard" component={Dashboard}/>
            </Switch>
        );
    }
}

export default WelcomeScreen;