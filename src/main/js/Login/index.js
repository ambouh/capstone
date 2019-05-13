import React, { Component} from 'react' ;
import { Link } from 'react-router-dom';
import auth from '../auth';
import axios from 'axios';

class Login extends Component {
    state ={
       message: ''
    };

    user = {
        username: "jsmith",
        password: "pw"
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
                </form>
            </div>


        );
    }
}

export default Login;