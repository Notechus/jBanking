


var React = require('react');
var PageHeader = require('react-bootstrap').PageHeader;


var AccountBalance = React.createClass(
    {

        getInitialState: function () {
            return {view: 1, logged: 0};
            this.getAccountData();
        },
        render: function () {

            return (
                <div className="container" id="mainBody">

                    <PageHeader> Account</PageHeader>
                    <h1> Balance</h1><br/>
                    <button type="button" onClick={this.getAccountData}>Refres</button>

                    </div>
            );
        },
        getAccountData: function () {
            var AjaxResult;
            AjaxResult = "";
            console.log('COS');
            $.ajax({
                type: "POST",
                url: 'https://85.255.11.168:8443/api/v1/account/notechus',
                // data: JSON.stringify(data),
                dataType: 'json',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                    'Authorization':'Bearer eyJraWQiOiI3MEROWkZDUzE5Qjc1UUY5NENKMFk4V1I5Iiwic3R0IjoiYWNjZXNzIiwiYWxnIjoiSFMyNTYifQ.eyJqdGkiOiIyOVV6WFY0UW1VZGx1azhyRllPaFBlIiwiaWF0IjoxNDg0MjM2ODQ1LCJpc3MiOiJodHRwczovL2FwaS5zdG9ybXBhdGguY29tL3YxL2FwcGxpY2F0aW9ucy82TXQ2ald0TW9meFlyQW9mQWhHUmZIIiwic3ViIjoiaHR0cHM6Ly9hcGkuc3Rvcm1wYXRoLmNvbS92MS9hY2NvdW50cy83SWczR2tpRHNrU0ZsalpRVmQ4TG5QIiwiZXhwIjoxNDg0MjM3NzQ1fQ.2aAHP1fgN6flio8VCp2uohaiQYdBF4w-QfbK8nj_26s'
                },
                success: function (response) {
                    console.log(AjaxResult);
                },

            });
            console.log(AjaxResult);
            this.forceUpdate();
        }
    });

module.exports = AccountBalance;