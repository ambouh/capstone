import React, { Component } from 'react';
import UserNavigation from "./UserNavigation";
import {Switch, Route} from 'react-router-dom';
import Summary from "./Summary";
//import AllTransactions from "./AllTransactions";


class Dashboard extends Component {

    title = "dashboard";

    render() {
        return (
            <div className={"wrapper"}>
                <UserNavigation/>
                <Switch>
                    <Route exact path={"/dashboard"} component={Summary}/>
                  {/*  <Route exact path={"/dashboard/transactions"} component={AllTransactions}/>*/}
                </Switch>
            </div>

        );
    }
}

export default Dashboard;