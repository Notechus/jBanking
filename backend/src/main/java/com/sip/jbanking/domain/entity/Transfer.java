package com.sip.jbanking.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author notechus.
 */
@Entity
public class Transfer implements com.sip.jbanking.domain.entity.Entity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "SENDER_ID")
    private Account sender;

    @OneToOne
    @JoinColumn(name = "RECEIVER_ID")
    private Account receiver;

    @Column(name = "transactiontime")
    private Date timestamp;

    @OneToOne(targetEntity = Currency.class)
    private Currency currency;

    private double amount;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSender() {
        return sender;
    }

    public void setSender(Account sender) {
        this.sender = sender;
    }

    public Account getReceiver() {
        return receiver;
    }

    public void setReceiver(Account receiver) {
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

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof Transfer)) return false;

        Transfer that = (Transfer) o;

        return new EqualsBuilder()
                .append(amount, that.amount)
                .append(id, that.id)
                .append(sender, that.sender)
                .append(receiver, that.receiver)
                .append(currency, that.currency)
                .append(description, that.description)
                .append(timestamp, that.timestamp)
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
