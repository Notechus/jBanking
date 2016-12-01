package com.sip.jbanking.service;

import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.to.AccountTO;
import com.sip.jbanking.domain.to.UserTO;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface AccountService {
    public Account getAccountById(long id);
    public Account getAccountByNumber(String accountNumber);
    public Account getUserAccount(UserTO user);
}