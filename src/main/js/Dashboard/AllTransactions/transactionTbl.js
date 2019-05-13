import React, {Component} from 'react';


class TransactionTbl extends Component {

    render() {
        const {userTransaction} = this.props;

        console.log("from trTbl: " + userTransaction);
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

                {


                    userTransaction.map((data) => {
                        const arr = data.split(",");
                        return (
                            <tr>
                                <td>{arr[0]}</td>
                                <td>$ {arr[1]}</td>
                                <td>{arr[2]}</td>
                                <td>{arr[3]}</td>
                            </tr>
                        )
                    })


                }


                </tbody>
            </table>
        );
    }

}

export default TransactionTbl;