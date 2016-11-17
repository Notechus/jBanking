package com.sip.jbanking.service;

import com.sip.jbanking.domain.entity.Transaction;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface TransferService {
    public Transaction getTransactionById(long id);
    public boolean verifyTransaction(String accountNumber, String name);
}
