import React, { Component } from 'react';
import {Link} from 'react-router-dom';
import Auth from '../../auth';
import {withRouter} from 'react-router-dom';

class UserNavigation extends Component {

    handleLogout = (event) => {
        event.preventDefault();
        Auth.logout(()=>{this.props.history.push("/logout")});
    };
    logoutBtn = {
        textDecoration: "none",
        fontFamily: "Agency FB",
        fontSize: "30px",
        color: "#FFF",
        "cursor" : "pointer"
    };
    render() {
        return(
          <div className={"navigation"}>
              <ul style={{width:"220px"}}>
                  <li><Link to={"/dashboard"}>Dashboard</Link></li>
                  <li><Link to={"/dashboard/transactions"}>All Transactions</Link></li>
                  <li style={this.logoutBtn} onClick={this.handleLogout}>Logout</li>
              </ul>
          </div>
        )
    }
}

export default withRouter(UserNavigation);