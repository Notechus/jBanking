var AppDispatcher = require('../dispatcher/AppDispatcher');
var EventEmitter = require('events').EventEmitter;
var assign = require('object-assign');
var moment = require('moment');
var util = require('util');

var AccountStore = assign({}, EventEmitter.prototype, {
    accountInfo: {},
    receivedTransfers: [],
    sentTransfers: [],
    emitChange: function () {
        this.emit('change');
    },
    addChangeListener: function (callback) {
        this.on('change', callback);
    },
    removeChangeListener: function (callback) {
        this.removeListener('change', callback);
    },
    getSentTransfers: function () {
        return this.sentTransfers;
    },
    getReceivedTransfers: function () {
        return this.receivedTransfers;
    },
    getAccountInfo: function () {
        return this.accountInfo
    },
    getUsername: function () {
        return this.accountInfo['username'];
    },
    getAccountNumber: function () {
        return this.accountInfo['accountNumber'];
    },
    loadAccountInfo: function (url) {
        var self = this;
        $.getJSON(url, '', function (result) {
            result.accountNumber = self.transformAccountNumber(result.accountNumber);
            self.accountInfo = result;
            self.emitChange();
        });
    },
    loadSentTransfers: function (url) {
        var self = this;
        $.getJSON(url, '', function (result) {
            result.forEach(function (item) {
                item.receiverAccNumber = self.transformAccountNumber(item.receiverAccNumber);
                item.senderAccNumber = self.transformAccountNumber(item.senderAccNumber);
                self.sentTransfers.push(item);
            });
            self.emitChange();
        });
    },
    loadReceivedTransfers: function (url) {
        var self = this;
        $.getJSON(url, '', function (result) {
            result.forEach(function (item) {
                item.senderAccNumber = self.transformAccountNumber(item.senderAccNumber);
                item.receiverAccNumber = self.transformAccountNumber(item.receiverAccNumber);
                self.receivedTransfers.push(item);
            });
            self.emitChange();
        });
    },
    transformAccountNumber: function (number) {
        let p1 = number.slice(0, 2);
        let p2 = number.slice(2, 6);
        let p3 = number.slice(6, 10);
        let p4 = number.slice(10, 14);
        let p5 = number.slice(14, 18);
        let p6 = number.slice(18, 22);
        let p7 = number.slice(22, 26);

        return p1 + ' ' + p2 + ' ' + p3 + ' ' + p4 + ' ' + p5 + ' ' + p6 + ' ' + p7;
    },
    postTransfer: function (url, transfer) {
        var self = this;
        $.ajax({
            url: url,
            type: 'POST',
            data: JSON.stringify(transfer),
            headers: {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            },
            dataType: 'json',
            complete: function (data) {
                self.getSentTransfers();
                self.getReceivedTransfers();
                self.getAccountInfo();
            }
        });
        // $.ajax({
        //     url: 'YourRestEndPoint',
        //     headers: {
        //         'Authorization': 'Basic xxxxxxxxxxxxx',
        //         'X_CSRF_TOKEN': 'xxxxxxxxxxxxxxxxxxxx',
        //         'Content-Type': 'application/json'
        //     },
        //     method: 'POST',
        //     dataType: 'json',
        //     data: YourData,
        //     success: function (data) {
        //         console.log('succes: ' + data);
        //     }
        // });
    }
});

AppDispatcher.register(function (action) {
    switch (action.actionType) {
        case 'ACCOUNT_GET_INFO':
            AccountStore.loadAccountInfo(action.data.url);
            AccountStore.emitChange();
            break;
        case 'PORTFOLIO_GET_SENT':
            AccountStore.loadSentTransfers(action.data.url);
            AccountStore.emitChange();
            break;
        case 'PORTFOLIO_GET_RECEIVED':
            AccountStore.loadReceivedTransfers(action.data.url);
            AccountStore.emitChange();
            break;
        case 'PORTFOLIO_NEW_TRANSFER':
            AccountStore.postTransfer(action.data.url, action.data.transfer);
            AccountStore.emitChange();
            break;
    }
});

module.exports = AccountStore;

