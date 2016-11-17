package com.sip.jbanking.domain.to;

import java.io.Serializable;

/**
 * @author notechus.
 */
public class TransferDTO implements Serializable {

    private String senderAccNumber;
    private String receiverAccNumber;
    private double amount;
    private String name;
    private String title;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
