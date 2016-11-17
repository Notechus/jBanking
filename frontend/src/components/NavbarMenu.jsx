var React = require('react');
var Nav = require('react-bootstrap').Nav;
var NavItem = require('react-bootstrap').NavItem;
var Navbar = require('react-bootstrap').Navbar;

const NavbarMenu = React.createClass({
    changePageView: function (eventKey, event) {
        this.props.handleViews(eventKey);
    },
    render: function () {
        return (
            <Navbar inverse fluid>
                <Navbar.Header>
                    <Navbar.Brand>
                        <a id="brand-name">jBanking</a>
                    </Navbar.Brand>
                </Navbar.Header>
                <Nav>
                    <NavItem eventKey={1} onSelect={this.changePageView} href="#">Account</NavItem>
                </Nav>
                <Nav pullRight>
                    <Navbar.Text>You are logged as: <strong>User</strong> </Navbar.Text>

                </Nav>
            </Navbar>);
    }
});
module.exports = NavbarMenu;