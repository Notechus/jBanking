var React = require('react');
var Nav = require('react-bootstrap').Nav;
var NavItem = require('react-bootstrap').NavItem;
var Navbar = require('react-bootstrap').Navbar;
var AccountStore = require('../store/AccountStore');

function getUsernameFromStore() {
    return AccountStore.getUsername();
}

const NavbarMenu = React.createClass({
        getInitialState: function () {
            return {username: ''};
        },
        onUsernameChange: function () {
            this.setState({username: AccountStore.getUsername()});
        },
        componentDidMount(){
            AccountStore.addChangeListener(this.onUsernameChange);
        },
        componentWillUnmount: function () {
            AccountStore.removeChangeListener(this.onUsernameChange);
        },
        changePageView: function (eventKey, event) {
            this.props.handleViews(eventKey);
        },
        render: function () {
            if (this.state.username === '') {
                return (
                    <Navbar inverse fluid fixedTop>
                        <Navbar.Header>
                            <Navbar.Brand>
                                <a id="brand-name">jBanking</a>
                            </Navbar.Brand>
                        </Navbar.Header>
                        <Nav>
                            <NavItem eventKey={1} onSelect={this.changePageView} href="#">Account</NavItem>
                        </Nav>
                    </Navbar>);
            } else {
                return (
                    <Navbar inverse fluid fixedTop>
                        <Navbar.Header>
                            <Navbar.Brand>
                                <a id="brand-name">jBanking</a>
                            </Navbar.Brand>
                        </Navbar.Header>
                        <Nav>
                            <NavItem eventKey={1} onSelect={this.changePageView} href="#">Account</NavItem>
                        </Nav>
                        <Nav pullRight>
                            <Navbar.Text>You are logged as: <strong>{this.state.username}</strong> </Navbar.Text>
                        </Nav>
                    </Navbar>);
            }
        }
    })
    ;
module.exports = NavbarMenu;