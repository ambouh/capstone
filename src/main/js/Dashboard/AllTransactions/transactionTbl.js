import React, {Component} from 'react';


class TransactionTbl extends Component {

    render(){
        const {userTransaction} = this.props;
        return (
            <table className={"transactionTbl"}>
                <thead>
                <tr>
                    <th>TRANSACTION</th>
                    <th>AMOUNT</th>
                    <th>CATEGORY</th>
                    <th>TYPE</th>
                </tr>
                </thead>
                <tbody>
                {userTransaction.map((data, i) => {
                    return (
                        <tr key={i}>
                            <td>{data["TRANSACTION_MERCHANT"]}</td>
                            <td>$ {data["TRANSACTION_AMOUNT"]}</td>
                            <td>{data["TRANSACTION_CATEGORY"]}</td>
                            <td>{data["TRANSACTION_TYPE"]}</td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        );
    }

}

export default TransactionTbl;