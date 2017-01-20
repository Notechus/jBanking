var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;
var Panel = require('react-bootstrap').Panel;
var Table = require('react-bootstrap').Table;
var AppDispatcher = require('../dispatcher/AppDispatcher');
var AccountStore = require('../store/AccountStore');

function getAccountFromStore() {
    return AccountStore.getAccountInfo();
}

function getSentFromStore() {
    return AccountStore.getSentTransfers();
}

function getReceivedFromStore() {
    return AccountStore.getReceivedTransfers();
}

var AccountBalance = React.createClass({
    getInitialState: function () {
        return {
            view: 1,
            logged: 0,
            accountInfo: getAccountFromStore(),
            sentTransfers: getSentFromStore(),
            receivedTransfers: getReceivedFromStore()
        }
            ;
    },
    onAccountChange(){
        this.setState({
            accountInfo: getAccountFromStore(),
            sentTransfers: getSentFromStore(),
            receivedTransfers: getReceivedFromStore()
        });
    },
    componentDidMount: function () {
        AccountStore.addChangeListener(this.onAccountChange);
    },
    componentWillUnmount: function () {
        AccountStore.removeChangeListener(this.onAccountChange);
    },
    render: function () {
        const accountTitle = (
            <h3>Account Information</h3>
        );
        const receivedTitle = (
            <h3>Received Transfers</h3>
        );
        const sentTitle = (
            <h3>Sent Transfers</h3>
        );
        const account = this.state.accountInfo;
        let sentBody = [];
        let receivedBody = [];
        let counter = 1;
        let item = '';
        for (var i  in this.state.sentTransfers) {
            item = this.state.sentTransfers[i];
            sentBody.push(
                <tr>
                    <td>{counter}</td>
                    <td>{item.receiverAccNumber}</td>
                    <td>{item.title}</td>
                    <td>{item.amount + ' ' + item.currency}</td>
                    <td>{item.timestamp}</td>
                </tr>);
            counter++;
        }
        counter = 1;
        for (var i  in this.state.receivedTransfers) {
            item = this.state.receivedTransfers[i];
            receivedBody.push(
                <tr>
                    <td>{counter}</td>
                    <td>{item.senderAccNumber}</td>
                    <td>{item.title}</td>
                    <td>{item.amount + ' ' + item.currency}</td>
                    <td>{item.timestamp}</td>
                </tr>);
            counter++;
        }
        return (
            <div>
                <PageHeader> Account </PageHeader>
                <div className="row">
                    <div className="col-md-12">
                        <Panel header={accountTitle}>
                            <Table responsive>
                                <tbody>
                                <tr>
                                    <td>Account number:</td>
                                    <td>{account.accountNumber}</td>
                                </tr>
                                <tr>
                                    <td>Full name:</td>
                                    <td>{account.fullName}</td>
                                </tr>
                                <tr>
                                    <td>Balance:</td>
                                    <td>{account.balance} PLN</td>
                                </tr>
                                </tbody>
                            </Table>
                        </Panel>
                    </div>
                    <div className="row">
                        <div className="col-md-6 padded-left">
                            <Panel header={sentTitle}>
                                <Table responsive bordered>
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Receiver account</th>
                                        <th>Title</th>
                                        <th>Amount</th>
                                        <th>Date</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {sentBody}
                                    </tbody>
                                </Table>
                            </Panel>
                        </div>
                        <div className="col-md-6 padded-right">
                            <Panel header={receivedTitle}>
                                <Table responsive bordered>
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Sender account</th>
                                        <th>Title</th>
                                        <th>Amount</th>
                                        <th>Date</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    {receivedBody}
                                    </tbody>
                                </Table>
                            </Panel>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
});

module.exports = AccountBalance;