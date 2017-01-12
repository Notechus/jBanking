package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.bean.AccountDAOBean;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.mappings.AccountMapper;
import com.sip.jbanking.domain.mappings.AccountMapperImpl;
import com.sip.jbanking.domain.to.AccountTO;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ziolson
 */
public class AccountServiceBeanTest {

    private AccountDAO accountDAO = Mockito.mock(AccountDAOBean.class);
    private AccountMapper accountMapper = new AccountMapperImpl();
    private AccountServiceBean accountService = new AccountServiceBean(accountDAO, accountMapper);

    private static final String ACCOUNT_NUMBER = "1234567890";
    private static final String USERNAME = "login";
    private static final long ID = 1;
    private static final double BALANCE = 100.0;

    @Test
    public void getAccountByUsernameTest() {
        User user = createUser();
        Account account = createAccount(user);
        when(accountDAO.findByUsername(USERNAME)).thenReturn(account);
        AccountTO accountTo = accountService.getAccountByUsername(USERNAME);

        assertEquals(ACCOUNT_NUMBER, accountTo.getAccountNumber());
    }

    private Account createAccount(User user) {
        Account a = new Account();
        a.setId(ID);
        a.setAccountNumber(ACCOUNT_NUMBER);
        a.setOwner(user);
        a.setBalance(BALANCE);

        return a;
    }

    private User createUser() {
        User u = new User();
        u.setUsername(USERNAME);

        return u;
    }
}
