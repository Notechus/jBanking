// return (
//     <div id="portfolio">
//         <Tabs activeKey={this.state.key} onSelect={this.handleSelect} id="portfolioTabs">
//             <Tab eventKey={1} title="Created Options"><CreatedOptionTable/></Tab>
//             <Tab eventKey={2} title="Option Trades"><OptionTradeTable/></Tab>
//             <Tab eventKey={3} title="Stock Trades"><StockTradeTable/></Tab>
//         </Tabs>
//     </div>
// );



var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;


var TransferMoney = React.createClass(
    {
        handleValueChange: function (e) {
            this.setState({value: e.target.value});
        },
        handleAccountChange: function (e) {
            this.setState({account: e.target.value});
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
        getInitialState: function () {
            return {view: 1, logged: 0};
        },
        render: function () {
            return (
                <div className="container" id="mainBody">

                    <form>
                        <h1> Transfer Money </h1>
                        <input type="text" name="name" placeholder="Name" onChange={this.handleNameChange}/>
                        <br/>
                        <input type="text" name="surname" placeholder="Surname"
                               onChange={this.handleSurnameChange}/> <br/>
                        <input type="text" name="account" placeholder="Destination Account"
                               onChange={this.handleAccountChange}/> <br/>
                        <input type="text" name="value" placeholder="Value" onChange={this.handleValueChange}/>
                        <br/>
                        <input type="text" name="title" placeholder="Title" onChange={this.handleTitleChange}/>
                        <br/>
                        <input type="text" name="currency" value="PLN" disabled/> <br/>
                        <button type="button" onClick={this.handleTransfer}>Transfer Money</button>
                    </form>
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

module.exports = TransferMoney;