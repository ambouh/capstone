import React, { Component} from 'react';


class TransactionForm extends Component {
    state = {
        merchant: "",
        amount: "",
        category: ""
    };

    handleInputChange = (event) =>{
        const target = event.target;
        const value = target.type === 'checkbox' ? target.checked : target.value;
        const name = target.name;

        this.setState({
            [name]: value
        });
    };



    handleAddTrans = (event)=>{
        event.preventDefault();
        const {merchant, amount, category} = this.state;
        this.props.handleTransactionView(merchant, amount, category);
        this.props.handleTransactionForm(event);
    };

    render(){
        return(
            <div>
                <form className={"transactionForm"}>
                    <input value={this.state.merchant} onChange={this.handleInputChange} name={"merchant"} placeholder={"enter merchant"}/>
                    <input value={this.state.amount}  onChange={this.handleInputChange} name={"amount"} placeholder={"enter amount"}/>
                    <input value={this.state.category} onChange={this.handleInputChange} name={"category"} placeholder={"enter category"}/>
                    <button className={"button submit"} onClick={this.handleAddTrans}>submit</button>
                </form>
            </div>
        );
    };
}

export default  TransactionForm;