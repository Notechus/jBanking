 var React = require('react');
//
// var LoginForm = React.createClass({
//     propTypes: {
//         value: React.PropTypes.object.isRequired
//     },
//
//     render: function() {
//         return (
//             React.createElement('form', {className: 'LoginForm'},
//                 React.createElement('input', {
//                     type: 'text',
//                     placeholder: 'Login (required)',
//                     value: this.props.value.login,
//                 }),
//                 React.createElement('input', {
//                     type: 'password',
//                     placeholder: 'Password',
//                     value: this.props.value.email,
//                 }),
//                 React.createElement('button', {type: 'submit'}, "Login")
//             )
//         )
//     },
// });

var LoginForm  = React.createClass({
    propTypes: {
        value: React.PropTypes.object.isRequired
    },

    render: function() {
        return (
            React.createElement('form', {className: 'LoginForm '},
                React.createElement('input', {
                    type: 'text',
                    placeholder: 'Name (required)',
                    value: this.prop.calue,
                }),
                React.createElement('input', {
                    type: 'text',
                    placeholder: 'Password',
                    value: localStorage.password,
                }),
                React.createElement('button', {type: 'submit'}, "Add Contact")
            )
        )
    },
});
 module.exports = LoginForm;