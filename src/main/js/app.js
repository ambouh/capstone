import React, { Component } from 'react';
import { render } from 'react-dom';
import axios from "axios";

class App extends Component {

    getUser(event){
        let localServer = "http://localhost:60080/api";
        event.preventDefault();

        axios.get(localServer + "/all?person_id=1")
            .then((resp)=>{
                const data = resp.data.toString();
                console.log(data);
            }).catch();
    };

    render() {
        return (
            <div id="container">
                SHOW ME REACT...IS BEING RENDERED!
                <button onClick={this.getUser}>Click me to get the data</button>
            </div>
        );
    }
}

render(
    <App />,
    document.getElementById('react')
);
