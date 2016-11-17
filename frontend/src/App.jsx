var React = require('react');
var ReactDOM = require('react-dom');
var NavbarMenu = require('./components/NavbarMenu');
var MainBody = require('./components/MainBody');
var AppDispatcher = require('./dispatcher/AppDispatcher');
var WebSocket = require('./components/WebSocket');

var App = React.createClass({
    handleViews: function (key) {
        if (this.state.view != key) this.setState({view: key});
    },
    getInitialState: function () {
        return {view: 1};
    },

    componentDidMount: function () {
        AppDispatcher.dispatch({
            actionType: 'ACCOUNT_GET',
            data: {
                url: "http://www.x.com", options: ""
            }
        });

        WebSocket.addMessageHandler(this.handleMessage);
    },
    render: function () {
        return (
            <div>
                <NavbarMenu handleViews={this.handleViews}/>
                <MainBody />



            </div>);
    }
});

window.onload = () => {
    ReactDOM.render(<App/>, document.getElementById('content'));
}