package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.to.AccountTO;
import com.sip.jbanking.domain.to.UserTO;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by ziolson on 24.11.2016.
 */
public class AccountServiceBeanTest {

    private AccountDAO accountDAO = Mockito.mock(AccountDAO.class);
    private AccountServiceBean accountService = new AccountServiceBean(accountDAO);

    private static final String ACCOUNT_NUMBER = "1234567890";
    private static final String USERNAME = "login";
    private static final String FULL_NAME = "Imie Nazwisko";
    

    private UserTO prepareUser() {
        AccountTO account = new AccountTO();
        account.setAccountNumber(ACCOUNT_NUMBER);

        UserTO user = new UserTO();
        user.setAccount(account);
        user.setFullName(FULL_NAME);
        user.setUsername(USERNAME);

        return user;
    }
}
