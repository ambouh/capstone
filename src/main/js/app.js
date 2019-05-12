import React, { Component } from 'react';
import { render } from 'react-dom';
import { BrowserRouter } from 'react-router-dom';
import WelcomeScreen from './WelcomeScreen';

class App extends Component {

    render() {
        let logo = "https://ambouh.github.io/transaxions/static/media/whitelogo.157efa52.svg";
        return (
            <div id="container">
                <div className="upperDiv">
                    <img src={logo} className="logo" alt="Transaxions Logo" />
                </div>
                <div className="midDiv">
                    <WelcomeScreen/>
                </div>
                <div className="bottomDiv">
                    <p>Copyright 2019 Transaxions | World's Greatest Ledger App</p>
                </div>
            </div>
        );
    }
}

render(
    <BrowserRouter>
        <App />
    </BrowserRouter>,
    document.getElementById('react')
);