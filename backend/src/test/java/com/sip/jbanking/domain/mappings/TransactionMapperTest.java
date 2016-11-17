package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferTO;
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
    private TransferMapper mapper;

    private static final String USERNAME = "Greg";
    private static final String USERNAME2 = "Willy";
    private static final String NAME = "Gregory";
    private static final String NAME2 = "William";
    private static final String SURNAME = "House";
    private static final String SURNAME2 = "Shakespeare";
    private static final String EMAIL = "email@email.com";
    private static final String EMAIL2 = "email2@email.com";
    private static final String CURRENCY_NAME = "PLN";
    private static final double PRICE = 2.01;
    private static final String DESCRIPTION = "Some description";
    private static final double AMOUNT = 100.0;
    private static final String FULL_NAME = "Gregory House";
    private static final String FULL_NAME2 = "William Shakespeare";
    private static final String ACC_NUMBER = "1234567890";
    private static final String ACC_NUMBER2 = "09887654321";

    @Test
    public void shouldMapTransactionToTransactionTO() {
        Transfer transaction = prepareTransaction();

        TransferTO transactionTO = mapper.transactionToTransactionTO(transaction);

        assertEquals(expectedTransactionTO(), transactionTO);
    }


    private Transfer prepareTransaction() {
        Transfer t = new Transfer();
        t.setAmount(AMOUNT);
        Currency c = new Currency();
        c.setName(CURRENCY_NAME);
        c.setPrice(PRICE);
        t.setCurrency(c);
        t.setDescription(DESCRIPTION);
//        t.setSender(prepareUser(USERNAME, NAME, SURNAME, EMAIL));
//        t.setReceiver(prepareUser(USERNAME2, NAME2, SURNAME2, EMAIL2));

        return t;
    }

    private TransferTO expectedTransactionTO() {
        TransferTO t = new TransferTO();
        t.setTitle(DESCRIPTION);
        t.setAmount(AMOUNT);
        t.setCurrency(CURRENCY_NAME);
        t.setSenderAccNumber(ACC_NUMBER);
        t.setReceiverAccNumber(ACC_NUMBER2);

        return t;
    }
}