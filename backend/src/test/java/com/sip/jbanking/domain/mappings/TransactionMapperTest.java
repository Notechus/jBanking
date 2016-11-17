package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.entity.Transaction;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.to.TransactionTO;
import com.sip.jbanking.domain.to.UserTO;
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
@ContextConfiguration(classes = TestConfiguration.class)
public class TransactionMapperTest {

    @Autowired
    private TransactionMapper mapper;

    private static final String USERNAME = "Greg";
    private static final String USERNAME2 = "Willy";
    private static final String NAME = "Gregory";
    private static final String NAME2 = "William";
    private static final String SURNAME = "House";
    private static final String SURNAME2 = "Shakespeare";
    private static final String EMAIL = "email@email.com";
    private static final String EMAIL2 = "email2@email.com";
    private static final String CURRENCY_NAME = "PLN";
    private static final double BUY_PRICE = 2.01;
    private static final double SELL_PRICE = 1.98;
    private static final String DESCRIPTION = "Some description";
    private static final double AMOUNT = 100.0;
    private static final String FULL_NAME = "Gregory House";

    private static final String FULL_NAME2 = "William Shakespeare";

    @Test
    public void shouldMapTransactionToTransactionTO() {
        Transaction transaction = prepareTransaction();

        TransactionTO transactionTO = mapper.transactionToTransactionTO(transaction);

        assertEquals(expectedTransactionTO(), transactionTO);
    }


    private Transaction prepareTransaction() {
        Transaction t = new Transaction();
        t.setAmount(AMOUNT);
        Currency c = new Currency();
        c.setName(CURRENCY_NAME);
        c.setBuyPrice(BUY_PRICE);
        c.setSellPrice(SELL_PRICE);
        t.setCurrency(c);
        t.setDescription(DESCRIPTION);
        t.setSender(prepareUser(USERNAME, NAME, SURNAME, EMAIL));
        t.setReceiver(prepareUser(USERNAME2, NAME2, SURNAME2, EMAIL2));

        return t;
    }

    private TransactionTO expectedTransactionTO() {
        TransactionTO t = new TransactionTO();
        t.setDescription(DESCRIPTION);
        t.setAmount(AMOUNT);
        t.setCurrencyName(CURRENCY_NAME);
        t.setSender(prepareUserTO(USERNAME, FULL_NAME, EMAIL));
        t.setReceiver(prepareUserTO(USERNAME2, FULL_NAME2, EMAIL2));

        return t;
    }

    private UserTO prepareUserTO(String username, String fullName, String email) {
        UserTO userTO = new UserTO();
        userTO.setFullName(fullName);
        userTO.setUsername(username);
        userTO.setEmail(email);

        return userTO;
    }

    private User prepareUser(String username, String name, String surname, String email) {
        User user = new User();
        user.setUsername(username);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);

        return user;
    }

}