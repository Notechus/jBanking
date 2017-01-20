package com.sip.jbanking.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author notechus.
 */
public class TransferTO implements Serializable {

    private String senderAccNumber;
    private String receiverAccNumber;
    private double amount;
    private String title;
    private String currency;
    private String timestamp;

    public String getSenderAccNumber() {
        return senderAccNumber;
    }

    public void setSenderAccNumber(String senderAccNumber) {
        this.senderAccNumber = senderAccNumber;
    }

    public String getReceiverAccNumber() {
        return receiverAccNumber;
    }

    public void setReceiverAccNumber(String receiverAccNumber) {
        this.receiverAccNumber = receiverAccNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("senderAccNumber", senderAccNumber)
                .append("receiverAccNumber", receiverAccNumber)
                .append("amount", amount)
                .append("title", title)
                .append("currency", currency)
                .append("timestamp", timestamp)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        TransferTO that = (TransferTO) o;

        return new EqualsBuilder()
                .append(amount, that.amount)
                .append(senderAccNumber, that.senderAccNumber)
                .append(receiverAccNumber, that.receiverAccNumber)
                .append(title, that.title)
                .append(currency, that.currency)
                .append(timestamp, that.timestamp)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(senderAccNumber)
                .append(receiverAccNumber)
                .toHashCode();
    }
}
