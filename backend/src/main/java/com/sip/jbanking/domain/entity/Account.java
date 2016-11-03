package com.sip.jbanking.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * @author notechus.
 */
@Entity
public class Account extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = User.class)
    private User owner;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "BALANCE")
    private double balance;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || !(o instanceof Account)) return false;

        Account account = (Account) o;

        return new EqualsBuilder()
                .append(balance, account.balance)
                .append(id, account.id)
                .append(owner, account.owner)
                .append(accountNumber, account.accountNumber)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(owner)
                .append(accountNumber)
                .append(balance)
                .toHashCode();
    }
}
