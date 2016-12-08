package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.to.AccountTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author notechus.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MappingsTestConfiguration.class)
public class AccountMapperTest {

    @Autowired
    private AccountMapper mapper;

    private static final String ACCOUNT_NUMBER = "0000001";
    private static final double BALANCE = 127.35;
    private static final String USERNAME = "Greg";
    private static final String FULL_NAME = "Gregory House";
    private static final String NAME = "Gregory";
    private static final String SURNAME = "House";

    @Test
    public void shouldMapAccountToAccountTO() {
        //Given
        Account account = prepareAccount();

        //When
        AccountTO accountTO = mapper.accountToAccountTO(account);

        //Then
        assertEquals(expectedAccountTO(), accountTO);
    }

    private AccountTO expectedAccountTO() {
        AccountTO accountTO = new AccountTO();
        accountTO.setAccountNumber(ACCOUNT_NUMBER);
        accountTO.setBalance(BALANCE);
        accountTO.setUsername(USERNAME);
        accountTO.setFullName(FULL_NAME);

        return accountTO;
    }

    private Account prepareAccount() {
        Account account = new Account();
        account.setAccountNumber(ACCOUNT_NUMBER);
        account.setBalance(BALANCE);
        User user = new User();
        user.setUsername(USERNAME);
        user.setName(NAME);
        user.setSurname(SURNAME);
        account.setOwner(user);

        return account;
    }

}