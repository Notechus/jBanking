var React = require('react');
var Nav = require('react-bootstrap').Nav;
var NavItem = require('react-bootstrap').NavItem;
var Navbar = require('react-bootstrap').Navbar;
var Avatar = require('./Avatar');

const NavbarMenu = React.createClass({
    changePageView: function (eventKey, event) {
        this.props.handleViews(eventKey);
    },
    render: function () {
        return (
            <Navbar inverse fluid>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a id="brand-name">Trade Application</a>
                    </Navbar.Brand>
                </Navbar.Header>
                <Nav>
                    <NavItem eventKey={1} onSelect={this.changePageView} href="#">Account</NavItem>
                </Nav>
                <Nav pullRight>
                    <Navbar.Text>You are logged as: <strong>Trader</strong> </Navbar.Text>
                    <Avatar fluid/>
                </Nav>
            </Navbar>);
    }
});
module.exports = NavbarMenu;