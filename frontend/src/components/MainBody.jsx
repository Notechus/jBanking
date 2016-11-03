var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;

var MainBody = React.createClass({
        render: function () {
            switch (this.props.view) {
                case 1:
                    return (
                        <div className="container" id="mainBody">
                            <PageHeader> Account</PageHeader>

                        </div>
                    );
            }

        }
    })
    ;

module.exports = MainBody;