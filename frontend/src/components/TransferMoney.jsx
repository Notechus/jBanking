var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;
var Panel = require('react-bootstrap').Panel;
var Button = require('react-bootstrap').Button;
var FormGroup = require('react-bootstrap').FormGroup;
var ControlLabel = require('react-bootstrap').ControlLabel;
var FormControl = require('react-bootstrap').FormControl;

var AppDispatcher = require('../dispatcher/AppDispatcher');
var AccountStore = require('../store/AccountStore');

function getAccNumberFromStore() {
    return AccountStore.getAccountNumber();
}

var TransferMoney = React.createClass({
    getInitialState: function () {
        return {view: 1, logged: 0, myNumber: getAccNumberFromStore()};
    },
    onNumberChange: function () {
        this.setState({myNumber: getAccNumberFromStore()});
    },
    componentDidMount: function () {
        AccountStore.addChangeListener(this.onNumberChange);
    },
    componentWillUnmount: function () {
        AccountStore.removeChangeListener(this.onNumberChange);
    },
    handleValueChange: function (e) {
        this.setState({value: e.target.value});
    },
    handleAccountChange: function (e) {
        let str = e.target.value.replace(/\s+/g, '');
        this.setState({account: str});
    },
    handleNameChange: function (e) {
        this.setState({name: e.target.value});
    },
    handleSurnameChange: function (e) {
        this.setState({surname: e.target.value});
    },
    handleTitleChange: function (e) {
        this.setState({title: e.target.value});
    },
    handleTransfer: function () {
        AppDispatcher.dispatch({
            actionType: 'PORTFOLIO_NEW_TRANSFER',
            data: {
                url: "http://localhost:8443/api/v1/transfer",
                transfer: {
                    senderAccNumber: this.state.myNumber.replace(/\s+/g, ''),
                    receiverAccNumber: this.state.account,
                    amount: this.state.value,
                    title: this.state.title,
                    currency: 'PLN'
                }
            }
        });
    },
    render: function () {
        return (
            <div>
                <PageHeader> Transfer </PageHeader>
                <div className="row">
                    <div className="col-md-12">
                        <Panel header={title}>
                            <form>
                                <FormGroup controlId="accountText">
                                    <ControlLabel>Account Number</ControlLabel>
                                    <FormControl type="text" onChange={this.handleAccountChange}/>
                                    <FormControl.Feedback />
                                </FormGroup>
                                <FormGroup controlId="firstNameText">
                                    <ControlLabel>First Name</ControlLabel>
                                    <FormControl type="text" onChange={this.handleNameChange}/>
                                    <FormControl.Feedback/>
                                </FormGroup>
                                <FormGroup controlId="lastNameText">
                                    <ControlLabel>Last Name</ControlLabel>
                                    <FormControl type="text" onChange={this.handleSurnameChange}/>
                                    <FormControl.Feedback />
                                </FormGroup>
                                <FormGroup controlId="titleText">
                                    <ControlLabel>Title</ControlLabel>
                                    <FormControl type="text" onChange={this.handleTitleChange}/>
                                    <FormControl.Feedback />
                                </FormGroup>
                                <FormGroup controlId="amountText">
                                    <ControlLabel>Amount</ControlLabel>
                                    <FormControl type="text" onChange={this.handleValueChange}/>
                                    <FormControl.Feedback />
                                </FormGroup>
                                <FormGroup controlId="currency">
                                    <ControlLabel>Currency</ControlLabel>
                                    <FormControl componentClass="select" placeholder="select">
                                        <option value="select">PLN</option>
                                    </FormControl>
                                    <FormControl.Feedback />
                                </FormGroup>
                                <Button type="button" onClick={this.handleTransfer}>
                                    Send
                                </Button>
                            </form>
                        </Panel>
                    </div>
                </div>
            </div>
        );
        const title = (
            <h3>Make transfer</h3>
        );
    }
});

module.exports = TransferMoney;