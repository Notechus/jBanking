package com.sip.jbanking.domain.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Notechus.
 */
@Entity
public class User extends BaseEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(targetEntity = Account.class)
    private Account account;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(targetEntity = Location.class)
    private Location location;

    @Column(name = "PHONENUMBER")
    private Long phoneNumber;

    @ManyToMany
    @JoinTable(name = "USERTOTRANSACTION",//
            joinColumns = {@JoinColumn(name = "SENDER_ID")},//
            inverseJoinColumns = {@JoinColumn(name = "TRANSACTION_ID")})
    private List<Transaction> outgoingTransactions = new LinkedList<>();

    @ManyToMany
    @JoinTable(name = "USERTOTRANSACTION",//
            joinColumns = {@JoinColumn(name = "RECEIVER_ID")},//
            inverseJoinColumns = {@JoinColumn(name = "TRANSACTION_ID")})
    private List<Transaction> incomingTransactions = new LinkedList<>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(List<Transaction> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public List<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(List<Transaction> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof User)) return false;


        User user = (User) o;

        return new EqualsBuilder()
                .append(id, user.id)
                .append(account, user.account)
                .append(username, user.username)
                .append(password, user.password)
                .append(name, user.name)
                .append(surname, user.surname)
                .append(email, user.email)
                .append(location, user.location)
                .append(phoneNumber, user.phoneNumber)
                .append(outgoingTransactions, user.outgoingTransactions)
                .append(incomingTransactions, user.incomingTransactions)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(name)
                .append(location)
                .toHashCode();
    }
}
