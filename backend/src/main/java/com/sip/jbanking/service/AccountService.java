package com.sip.jbanking.service;

import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.to.AccountTO;
import com.sip.jbanking.domain.to.UserTO;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface AccountService {
    public AccountTO getAccountById(long id);
    public AccountTO getAccountByNumber(String accountNumber);
    public AccountTO getAccountByUsername(String username);
}