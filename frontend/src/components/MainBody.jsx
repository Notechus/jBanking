var AccountBalance = require('./AccountBalance');
var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;
var LoginForm = require('./LoginForm');
var Tabs = require('react-bootstrap').Tabs;
var Tab = require('react-bootstrap').Tab;
var TransferMoney = require('./TransferMoney');

var MainBody = React.createClass(
    {

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
            switch (localStorage.getItem('token') == "") {
                case false:
                    return (
                        <div className="container" id="mainBody">
                            <Tabs activeKey={this.state.key} onSelect={this.handleSelect} id="userTabs">
                                <Tab eventKey={1} title="Account Balance"><AccountBalance/></Tab>
                                <Tab eventKey={2} title="Transfer Money"><TransferMoney/></Tab>
                                         </Tabs>

                        </div>
                    );
                case true:

                    return (
                        <div className="container" id="mainBody">
                            <PageHeader> Log In</PageHeader>
                            <form>
                                <input type="text" name="login" placeholder="Login" onChange={this.handleLoginChange}/>
                                <input type="password" name="password" placeholder="Password"
                                       onChange={this.handlePasswordChange}/>
                                <button type="button" onClick={this.handleLogin}>Login</button>
                            </form>
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
            var AjaxResult;
            AjaxResult = "";

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

                },

            });
            this.forceUpdate();
        }
    });

module.exports = MainBody;