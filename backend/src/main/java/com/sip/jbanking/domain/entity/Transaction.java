package com.sip.jbanking.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * @author notechus.
 */
@Entity
public class Transaction extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "")
    private User sender;

    @OneToOne(mappedBy = "")
    private User receiver;

    @OneToOne(targetEntity = Currency.class)
    private Currency currency;

    private double amount;

    private String description;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
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

        if (o == null || !(o instanceof Transaction)) return false;

        Transaction that = (Transaction) o;

        return new EqualsBuilder()
                .append(amount, that.amount)
                .append(id, that.id)
                .append(sender, that.sender)
                .append(receiver, that.receiver)
                .append(currency, that.currency)
                .append(description, that.description)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(sender)
                .append(currency)
                .toHashCode();
    }
}
