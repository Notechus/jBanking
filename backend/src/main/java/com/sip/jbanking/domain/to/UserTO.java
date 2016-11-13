package com.sip.jbanking.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * @author notechus.
 */
public class UserTO implements Serializable {

    private AccountTO account;

    private String username;

    private String fullName;

    private String email;

    private LocationTO location;

    private long phoneNumber;

    private List<TransactionTO> outgoingTransactions = new LinkedList<>();

    private List<TransactionTO> incomingTransactions = new LinkedList<>();

    public AccountTO getAccount() {
        return account;
    }

    public void setAccount(AccountTO account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocationTO getLocation() {
        return location;
    }

    public void setLocation(LocationTO location) {
        this.location = location;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<TransactionTO> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(List<TransactionTO> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public List<TransactionTO> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(List<TransactionTO> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof UserTO)) return false;

        UserTO userTO = (UserTO) o;

        return new EqualsBuilder()
                .append(phoneNumber, userTO.phoneNumber)
                .append(account, userTO.account)
                .append(username, userTO.username)
                .append(fullName, userTO.fullName)
                .append(email, userTO.email)
                .append(location, userTO.location)
                .append(outgoingTransactions, userTO.outgoingTransactions)
                .append(incomingTransactions, userTO.incomingTransactions)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(email)
                .append(phoneNumber)
                .toHashCode();
    }
}
