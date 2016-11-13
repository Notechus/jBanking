package com.sip.jbanking.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author notechus.
 */
public class TransactionTO implements Serializable {

    private UserTO sender;

    private UserTO receiver;

    private String currencyName;

    private double amount;

    private String description;

    public UserTO getSender() {
        return sender;
    }

    public void setSender(UserTO sender) {
        this.sender = sender;
    }

    public UserTO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserTO receiver) {
        this.receiver = receiver;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof TransactionTO)) return false;

        TransactionTO that = (TransactionTO) o;

        return new EqualsBuilder()
                .append(amount, that.amount)
                .append(sender, that.sender)
                .append(receiver, that.receiver)
                .append(currencyName, that.currencyName)
                .append(description, that.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sender)
                .append(receiver)
                .toHashCode();
    }
}
