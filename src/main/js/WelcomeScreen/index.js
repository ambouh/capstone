import React, { Component } from 'react';
import {Route, Switch} from "react-router-dom";
import Login from "../Login";
import ProtectedRoute from '../protected.route';
import Dashboard from "../Dashboard";
import page404 from "../page404";
import Logout from "../Logout";

class WelcomeScreen extends Component {
    render() {
        return (
            <Switch>
                <Route exact path="/" component={Login}/>
                <ProtectedRoute path="/dashboard" component={Dashboard}/>
                <Route exact path="/logout" component={Logout}/>
                <Route path="*" component={page404}/>
            </Switch>
        );
    }
}

export default WelcomeScreen;