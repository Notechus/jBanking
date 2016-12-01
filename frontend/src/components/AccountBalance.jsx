


var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;


var AccountBalance = React.createClass(
    {

        getInitialState: function () {
            return {view: 1, logged: 0};
        },
        render: function () {
            return (
                <div className="container" id="mainBody">

                    <PageHeader> Account</PageHeader>
                    <h1> Balance</h1><br/>
                     ELO ELO SIEMA SIEMA
                    </div>
            );
        },
        getAccountData: function () {
            var AjaxResult;
            AjaxResult = "";
            var data = {
                eceiverAccNumber: this.state.account,
                senderAccNumber: '12345678909876543212345678',
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
        }
    });

module.exports = AccountBalance;