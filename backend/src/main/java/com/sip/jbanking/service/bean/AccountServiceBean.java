package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.UserDAO;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.to.UserTO;
import com.sip.jbanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ziolson on 24.11.2016.
 */

@Service("AccountService")
@Transactional
public class AccountServiceBean implements AccountService{

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private UserDAO userDAO;

    public AccountServiceBean() {
    }

    AccountServiceBean(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Account getAccountById(long id) {
        return null;
    }

    @Override
    public Account getAccountByNumber(String accountNumber) {
        return null;
    }

    @Override
    public Account getUserAccount(UserTO user) {
        return null;
    }
}
