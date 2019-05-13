import React, {Component} from 'react';
import axios from "axios";
import Auth from '../../auth';

class Summary extends Component {
    title = "Dashboard";

    state = {
        userTransaction: [],
        userData: []
    };

    getPersonData = (person_id) => {
        const verb = 'getPerson?person_id=' + person_id;
        const URL = Auth.getURL();
        const ax = axios.create({
            baseURL: URL
        });

        return ax.get(verb)
            .then((response) => {
                const data = response.data.split(",");



                return data;
            });
    };

    getUserTransactions(person_id){
        const verb = 'all?person_id=' + person_id;
        const URL = Auth.getURL();
        const ax = axios.create({
            baseURL: URL
        });

        return ax.get(verb)
            .then((response)=>{
                return response.data;
            });
    }


    componentDidMount() {
        const person_id = localStorage.getItem("person_id");

        this.getPersonData(person_id).then((response) => {
            console.log(response)
            this.setState({userData: response})
        });

        this.getUserTransactions(person_id).then((response) => {
            const top3 = [];
            for (let i = 0; i < 3; i++) {
                top3.push(response[i]);
            }
            this.setState({userTransaction: top3});
        });
    }

    render() {
        let { userData } = this.state;
        return(
            <div className="templateDiv">
                <h1 className={"templateTitle"} style={{marginBottom: 0}}>{this.title}</h1>
                <div className={"contentWrapper"}>
                    <div className={"content"}>
                        <h1 className={"templateTitle"}>(3) RECENT TRANSACTIONS ></h1>
                        <div className={"box"}>
                            <ul className={"recTransactions"}>

                                {this.state.userTransaction.map((data, i) => {
                                        let arr = data.split(",");
                                        return (
                                            <li className={"transaction"} key={i}>
                                                <div>
                                                    <p>{arr[0]}</p>
                                                    <p>{arr[2]}</p>
                                                </div>
                                                <span>$ {arr[1]}</span>
                                            </li>
                                        )
                                    }
                                )
                                }
                            </ul>
                        </div>
                    </div>
                    <div className={"content"}>
                        <h1 className={"templateTitle"}>ACCOUNTS ></h1>
                        <div className={"box"}>
                            <ul className={"recTransactions"}>
                                <li className={"transaction"}>
                                    <div>
                                        <p>CHECKING ACCOUNT #00{userData[0]}</p>
                                        <p>VISA </p>
                                    </div>
                                    <span style={{color: "#3E7BB8"}}>${userData[2]}</span>
                                </li>
                                <li className={"transaction"}>
                                    <div>
                                        <p>SAVINGS ACCOUNT #00{userData[0]}</p>
                                        <p>VISA </p>
                                    </div>
                                    <span style={{color: "#3E7BB8"}}>${userData[1]}</span>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Summary;