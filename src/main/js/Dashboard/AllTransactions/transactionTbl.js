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
                            const arr = data.split(",");
                            <td>{arr[0]}</td>
                            <td>$ {arr[1]}</td>
                            <td>{arr[2]}</td>
                            <td>{arr[3]}</td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        );
    }

}

export default TransactionTbl;