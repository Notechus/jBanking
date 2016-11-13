package com.sip.jbanking.domain.to;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

/**
 * @author notechus.
 */
public class AccountTO implements Serializable {

    private String username;

    private String fullName;

    private String accountNumber;

    private double balance;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof AccountTO)) return false;

        AccountTO accountTO = (AccountTO) o;

        return new EqualsBuilder()
                .append(balance, accountTO.balance)
                .append(username, accountTO.username)
                .append(fullName, accountTO.fullName)
                .append(accountNumber, accountTO.accountNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(username)
                .append(accountNumber)
                .toHashCode();
    }
}
