var AccountBalance = require('./AccountBalance');
var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;
var Button = require('react-bootstrap').Button;
var Panel = require('react-bootstrap').Panel;
var FormGroup = require('react-bootstrap').FormGroup;
var ControlLabel = require('react-bootstrap').ControlLabel;
var FormControl = require('react-bootstrap').FormControl;
var Tabs = require('react-bootstrap').Tabs;
var Tab = require('react-bootstrap').Tab;
var TransferMoney = require('./TransferMoney');
var AppDispatcher = require('../dispatcher/AppDispatcher');

var MainBody = React.createClass({
    handleLoginChange: function (e) {
        this.setState({login: e.target.value});
    },
    handlePasswordChange: function (e) {
        this.setState({password: e.target.value});
    },
    getInitialState: function () {
        return {view: 1, logged: 0};
    },
    render: function () {
        const title = (
            <h3>Log in</h3>
        );
        switch (localStorage.getItem('token') === "") {
            case false:
                return (
                    <div className="row" id="mainBody">
                        <div className="col-md-12">
                            <Tabs activeKey={this.state.key} onSelect={this.handleSelect}>
                                <Tab eventKey={1} title="Account Balance"><AccountBalance/></Tab>
                                <Tab eventKey={2} title="Transfer Money"><TransferMoney/></Tab>
                            </Tabs>
                        </div>
                    </div>
                );
            case true:
                return (
                    <div className="row" id="mainBody">
                        <div className="col-md-4 col-md-offset-4">
                            <PageHeader> Log In</PageHeader>
                            <Panel header={title}>
                                <form>
                                    <FormGroup controlId="usernameText">
                                        <ControlLabel>Username</ControlLabel>
                                        <FormControl type="text" onChange={this.handleLoginChange}/>
                                        <FormControl.Feedback />
                                    </FormGroup>
                                    <FormGroup controlId="passwordText">
                                        <ControlLabel>Password</ControlLabel>
                                        <FormControl type="password" onChange={this.handlePasswordChange}/>
                                        <FormControl.Feedback />
                                    </FormGroup>
                                    <Button type="button" onClick={this.handleLogin}>
                                        Submit
                                    </Button>
                                </form>
                            </Panel>
                        </div>
                    </div>
                );
        }

    },
    handleTransfer: function () {
        var AjaxResult;
        AjaxResult = "";
        var data = {
            amount: this.state.value,
            receiverAccNumber: this.state.account,
            senderAccNumber: '12345678909876543212345678',
            title: this.state.title,
            currency: "PLN"
        };
        $.ajax({
            type: "POST",
            url: 'http://localhost:8443/api/v1/transfer',
            data: JSON.stringify(data),
            dataType: 'json',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function (response) {
                AjaxResult = response;
            },

        });
        console.log(AjaxResult);
        this.forceUpdate();
    },

    handleLogin: function () {
        var self = this;
        $.ajax({
            type: "POST",
            url: 'https://85.255.11.168:8443/oauth/token?grant_type=password&username=gregory.house@jbanking.com&password=Password123',
            dataType: 'json',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
                'Accept': 'application/json'
            },
            success: function (response) {
                localStorage.setItem('token', response['access_token']);
                console.log(localStorage.getItem('token'));
                self.setState({logged: 1});
                AppDispatcher.dispatch({
                    actionType: 'ACCOUNT_GET_INFO',
                    data: {
                        url: "http://localhost:8443/api/v1/account/notechus"
                    }
                });
                AppDispatcher.dispatch({
                    actionType: 'PORTFOLIO_GET_SENT',
                    data: {
                        url: "http://localhost:8443/api/v1/transfer/notechus/sent"
                    }
                });
                AppDispatcher.dispatch({
                    actionType: 'PORTFOLIO_GET_RECEIVED',
                    data: {
                        url: "http://localhost:8443/api/v1/transfer/notechus/received"
                    }
                });
            },
        });
        this.forceUpdate();
    }
});

module.exports = MainBody;