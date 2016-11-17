var AccountBalance = require('./AccountBalance');
var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;
var LoginForm = require('./LoginForm');

var MainBody = React.createClass(

    {
        handleValueChange: function(e) {
            this.setState({value: e.target.value});
        },
        handleAccountChange: function(e) {
            this.setState({account: e.target.value});
        },
        handleNameChange: function(e) {
            this.setState({name: e.target.value});
        },
        handleSurnameChange: function(e) {
            this.setState({surname: e.target.value});
        },
        handleTitleChange: function(e) {
            this.setState({title: e.target.value});
        },
        handleLoginChange: function(e) {
            this.setState({login: e.target.value});
        },
        handlePasswordChange: function(e) {
            this.setState({password: e.target.value});
        },
        getInitialState: function () {
            return {view: 1, logged: 0};
        },
        render: function () {
            switch (this.state.logged) {
                case 1:
                    return (
                        <div className="container" id="mainBody">
                            <PageHeader> Account</PageHeader>
                            <h1> Balance</h1><br/>

                            <form>
                                <h1> Transfer Money </h1>
                                <input type="text" name="name" placeholder="Name" onChange={this.handleNameChange} /> <br/>
                                <input type="text" name="surname" placeholder="Surname" onChange={this.handleSurnameChange} /> <br/>
                                <input type="text" name="account" placeholder="Destination Account" onChange={this.handleAccountChange}/> <br/>
                                <input type="text" name="value" placeholder="Value" onChange={this.handleValueChange} /> <br/>
                                <input type="text" name="title" placeholder="Title" onChange={this.handleTitleChange} /> <br/>
                                <input type="text" name="currency"  value="PLN" disabled /> <br/>
                                <button type="button" onClick={this.handleTransfer}>Transfer Money</button>
                            </form>
                        </div>
                    );
                case 0:

                    return (
                        <div className="container" id="mainBody">
                            <PageHeader> Log In</PageHeader>
                                <form>
                                    <input type="text" name="login" placeholder="Login" onChange={this.handleLoginChange} />
                                    <input type="password" name="password" placeholder="Password" onChange={this.handlePasswordChange}/>
                                    <button type="button" onClick={this.handleLogin}>Login</button>
                                </form>
                        </div>
                    );
            }

        },
        handleTransfer: function() {
            var AjaxResult;
            AjaxResult = "";
            $.ajax({
                type: "POST",
                url: '/api/v1/transfer' ,
                data: { value: this.state.value,
                        account: this.state.account,
                        name: this.state.name},
                        surname: this.state.surname,
                        account: this.state.account,
                        title: this.state.title,
                        currency: this.state.currency,
                dataType: 'jsonp',
                success: function (response) {
                    //the response value is 'success'
                    AjaxResult = response;
                },
                // error: function (data, status, e) {
                //     alert("error:" + e);
                // }
            });
            console.log(AjaxResult);
            this.forceUpdate();
        },

        handleLogin: function() {
            var AjaxResult;
            AjaxResult = "";
            $.ajax({
                type: "POST",
                url: '/api/v1/login' ,
                data: { username: this.state.login, password: this.state.password },
                dataType: 'jsonp',
                success: function (response) {
                    //the response value is 'success'
                    AjaxResult = response;
                },
                // error: function (data, status, e) {
                //     alert("error:" + e);
                // }
            });
            console.log(this.state.password);
            this.state.logged = 1;
            this.forceUpdate();
        }
    });

module.exports = MainBody;