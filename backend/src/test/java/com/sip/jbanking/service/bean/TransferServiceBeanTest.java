package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.dao.bean.AccountDAOBean;
import com.sip.jbanking.domain.dao.bean.CurrencyDAOBean;
import com.sip.jbanking.domain.dao.bean.TransferDAOBean;
import com.sip.jbanking.domain.to.TransferDTO;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created by ziolson on 17.11.2016.
 */
public class TransferServiceBeanTest {

    private AccountDAO accountDAO = Mockito.mock(AccountDAOBean.class);
    private CurrencyDAO currencyDAO = Mockito.mock(CurrencyDAOBean.class);
    private TransferDAO transferDAO = Mockito.mock(TransferDAOBean.class);

    private TransferServiceBean transferService = new TransferServiceBean(transferDAO,accountDAO, currencyDAO);

    @Test
    public void shouldTransferMoney(){
        TransferDTO transfer = new TransferDTO();
        transfer.setAmount(105.8);
        transfer.setSenderAccNumber("ACC1");
        transfer.setReceiverAccNumber("ACC2");
        transfer.setCurrency("PLN");
        transfer.setName("Grzesiu Nowak");
        transfer.setTitle("hajs");

       boolean result =  transferService.transferMoney(transfer);

        assertTrue(result);
    }

}