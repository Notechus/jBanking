package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.mappings.AccountMapper;
import com.sip.jbanking.domain.to.AccountTO;
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
    private AccountMapper accountMapper;

    public AccountServiceBean() {
    }

    AccountServiceBean(AccountDAO accountDAO, AccountMapper accountMapper) {
        this.accountDAO = accountDAO;
        this.accountMapper = accountMapper;
    }

    @Override
    public AccountTO getAccountById(long id) {
        return accountMapper.accountToAccountTO(accountDAO.findById(id));
    }

    @Override
    public AccountTO getAccountByNumber(String accountNumber) {
        return accountMapper.accountToAccountTO(accountDAO.findByAccountNumber(accountNumber));
    }

    @Override
    public AccountTO getAccountByUsername(String username) {
        return accountMapper.accountToAccountTO(accountDAO.findByUsername(username));
    }
}
