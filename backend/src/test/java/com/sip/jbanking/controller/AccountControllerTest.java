package com.sip.jbanking.controller;

import com.sip.jbanking.domain.to.AccountTO;
import com.sip.jbanking.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

/**
 * @author notechus.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ControllerTestConfiguration.class)
public class AccountControllerTest {

    private static final String ACCOUNT_NUMBER = "12345678901234567890123456";
    private static final double BALANCE = 123.5;
    private static final String FULL_NAME = "Gregory House";
    private static final String USERNAME = "notechus";

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountController controller;

    @Test
    public void shouldGetAccountInfo() {
        given(this.accountService.getAccountByUsername(USERNAME)).willReturn(prepareAccountTO());

        ResponseEntity<AccountTO> response = controller.getAccount(USERNAME);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prepareAccountTO(), response.getBody());
    }

    private AccountTO prepareAccountTO() {
        AccountTO account = new AccountTO();
        account.setUsername(USERNAME);
        account.setAccountNumber(ACCOUNT_NUMBER);
        account.setBalance(BALANCE);
        account.setFullName(FULL_NAME);

        return account;
    }
}