package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.dao.bean.AccountDAOBean;
import com.sip.jbanking.domain.dao.bean.CurrencyDAOBean;
import com.sip.jbanking.domain.dao.bean.TransferDAOBean;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferTO;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by ziolson on 17.11.2016.
 */
public class TransferServiceBeanTest {

    private AccountDAO accountDAO = Mockito.mock(AccountDAOBean.class);
    private CurrencyDAO currencyDAO = Mockito.mock(CurrencyDAOBean.class);
    private TransferDAO transferDAO = Mockito.mock(TransferDAOBean.class);
    private TransferServiceBean transferService = new TransferServiceBean(transferDAO, accountDAO, currencyDAO);

    private static final String SENDER_ACC_NUMBER = "1234567890";
    private static final String RECEIVER_ACC_NUMBER = "0987654321";
    private static final String CURRENCY = "PLN";
    private static final String TITLE = "hajs";
    private static final double BALANCE = 100.0;
    private static final double AMOUNT = 10.0;
    private static final double PRICE = 3.97;
    private final double epsilon = 0.00001;

    @Test
    public void shouldTransferMoney() {
        TransferTO transfer = prepareTransfer();

        Account sender = createAccount(BALANCE, SENDER_ACC_NUMBER);
        Account receiver = createAccount(BALANCE, RECEIVER_ACC_NUMBER);
        when(accountDAO.findByAccountNumber(SENDER_ACC_NUMBER)).thenReturn(sender);
        when(accountDAO.findByAccountNumber(RECEIVER_ACC_NUMBER)).thenReturn(receiver);
        when(currencyDAO.findByName(transfer.getCurrency())).thenReturn(createCurrency(CURRENCY, PRICE));

        boolean result = transferService.transferMoney(transfer);

        assertEquals(BALANCE - 10.0, sender.getBalance(), epsilon);
        assertEquals(BALANCE + 10.0, receiver.getBalance(), epsilon);
        verify(accountDAO).update(sender);
        verify(accountDAO).update(receiver);
        verify(transferDAO).create(any(Transfer.class));

        assertTrue(result);
    }

    private Account createAccount(double balance, String accountNumber) {
        Account a = new Account();
        a.setBalance(balance);
        a.setAccountNumber(accountNumber);

        return a;
    }

    private Currency createCurrency(String name, double price) {
        Currency c = new Currency();
        c.setName(name);
        c.setPrice(price);

        return c;
    }

    private TransferTO prepareTransfer() {
        TransferTO transfer = new TransferTO();
        transfer.setAmount(AMOUNT);
        transfer.setSenderAccNumber(SENDER_ACC_NUMBER);
        transfer.setReceiverAccNumber(RECEIVER_ACC_NUMBER);
        transfer.setCurrency(CURRENCY);
        transfer.setTitle(TITLE);

        return transfer;
    }

}