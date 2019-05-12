import React, { Component} from 'react' ;
import { Link } from 'react-router-dom';
import auth from '../auth';
import axios from 'axios';

class Login extends Component {
    state ={
       message: ''
    };

    user = {
        username: "testuser",
        password: "test"
    };
    handleClick = (event)=>{
        event.preventDefault();
        auth.login(this.user.username, this.user.password, (response)=>{
            if (response.status === "SUCCESS") {
                this.props.history.push('/dashboard')
            } else {
                this.setState({
                    message: "Unable to validate"
                    }
                )
            }

        });
    };

    handleRequest = (event) => {
        event.preventDefault();

        let params = {
            "person_id" : "1",
            "transaction_id" : "1"
        };

        let pass = "b986ce68-be0e-4dd8-9da6-c37e0a39b2a5";
        axios.get("http://localhost:60080/api/transaction",
            {
                'Access-Control-Allow-Origin': '*',
                params: params,
                withCredentials: true,
                auth: {
                    username: 'user',
                    password: pass
                }
            }
            )
            .then((resp)=>{
                const data = resp.data;

                if(data){
                    console.log("There's data" + data.toString());
                } else {
                    console.log("there's nothing");
                }
            })
            .catch(function (error) {
                if (error.response) {
                    // The request was made and the server responded with a status code
                    // that falls out of the range of 2xx
                    console.log(error.response.data);
                    console.log(error.response.status);
                    console.log(error.response.headers);
                } else if (error.request) {
                    // The request was made but no response was received
                    // `error.request` is an instance of XMLHttpRequest in the browser and an instance of
                    // http.ClientRequest in node.js
                    console.log(error.request);
                } else {
                    // Something happened in setting up the request that triggered an Error
                    console.log('Error', error.message);
                }
                console.log(error.config);
            });
    };

    render(){
        return(
            <div className={"welcomeScreen"}>
                <form>
                    <p className={"error"}>{this.state.message}</p>
                    <input value={this.user.username} />
                    <input value={this.user.password} />
                    <button className={"button"} onClick={this.handleClick}>Sign In</button>
                    {/*<Link style={{textDecoration: "none"}}to="/register">
                        <button className={"button signUp"}>Sign Up</button>
                    </Link>*/}
                    <button className={"button"} onClick={this.handleRequest}>Handle Request</button>
                </form>
            </div>


        );
    }
}

export default Login;