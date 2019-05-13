import React, {Component} from 'react';
import axios from "axios";
import Auth from "../../auth";
import TransactionForm from "./transactionForm";
import TransactionTbl from "./transactionTbl";

class AllTransactions extends Component {

    state = {
        userTransaction: [],
        isTransactionOpen: false,
        isSubmitted: false,
        dataTrans: []
    };

    title = "All Transactions";

    getPersonId() {
        return localStorage.getItem("person_id");
    }

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
        const person_id = this.getPersonId();
        this.getUserTransactions(person_id).then((response) => {
            this.setState({userTransaction: response})
        });
    }


    handleTransactionView = (merchant, amount, category) => {
        let newTrans;
        if ((merchant!=="") &&(!isNaN(amount)) &&(category !=="")) {

            const verb = 'addTransaction?'+
                'transaction_merchant=' + merchant +
                '&person_id=' +this.getPersonId() +
                '&transaction_amount=' + amount +
                '&transaction_category=' + category;
            const URL = Auth.getURL();
            const ax = axios.create({
                baseURL: URL
            });

            newTrans = ax.get(verb)
                .then((response)=>{
                    return response.data;
                });

            this.setState({isSubmitted: true, userTransaction: newTrans});
        }
    };

    handleTransactionForm = (event) => {
        event.preventDefault();
        this.setState(prevState => ({
            isTransactionOpen: !prevState.isTransactionOpen
        }));

        if (this.state.isSubmitted) {
            this.setState({isSubmitted: false});
        }
    };

    render() {
        const {isTransactionOpen, userTransaction, isSubmitted} = this.state;
        let addTransView = null;
        let transBtnTitle = "add a transaction";

        if (isTransactionOpen) {
            addTransView = (<TransactionForm handleTransactionView={this.handleTransactionView}
                                             handleTransactionForm={this.handleTransactionForm}/>);
            transBtnTitle = "close form";
        }

        if (isSubmitted) {
            transBtnTitle = "add another transaction";
            addTransView = (
                <div>
                    <h1 className={"templateTitle"}>SUCCESS!</h1>
                    <p className={"templateText"}>Transaction was added successfully! Thanks.</p>
                </div>

            );
        }


        return (
            <div className="templateDiv">
                <h1 className={"templateTitle"}>{this.title}</h1>
                <TransactionTbl userTransaction={userTransaction}/>
                <div className={"addTransDiv"}>
                    <button className={"addTransBtn"} onClick={this.handleTransactionForm}> {transBtnTitle} </button>
                    <div>{addTransView}</div>
                </div>
            </div>
        );
    }

}

export default AllTransactions;