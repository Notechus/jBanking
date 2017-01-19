var React = require('react');

var TransferMoney = React.createClass({
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
            <div className="row">
                <div className="col-md-12">
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
            </div>
        );
    }
});

module.exports = TransferMoney;