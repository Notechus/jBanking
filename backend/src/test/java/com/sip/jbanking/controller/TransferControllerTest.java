package com.sip.jbanking.controller;

import com.google.common.collect.Lists;
import com.sip.jbanking.domain.to.TransferTO;
import com.sip.jbanking.service.TransferService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

/**
 * @author notechus.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ControllerTestConfiguration.class)
public class TransferControllerTest {

    private static final String SENDER_NUMBER = "12345678901234567890123456";
    private static final String RECEIVER_NUMBER = "09876543210987654321098765";
    private static final String TITLE = "some title";
    private static final double AMOUNT = 38.0;
    private static final String CURRENCY = "PLN";
    private static final String SENDER_USERNAME = "greg";
    private static final String RECEIVER_USERNAME = "notechus";

    @Autowired
    private TransferService transferService;

    @Autowired
    private TransferController controller;

    @Test
    public void shouldPostNewTransfer() {
        given(transferService.transferMoney(prepareTransfer())).willReturn(true);

        ResponseEntity response = controller.post(prepareTransfer());

        verify(transferService).transferMoney(prepareTransfer());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturnSentTransfers() {
        given(transferService.getTransferBySender(SENDER_USERNAME)).willReturn(Lists.newArrayList(prepareTransfer(), prepareTransfer()));

        ResponseEntity<List<TransferTO>> response = controller.getSentTransfers(SENDER_USERNAME);
        assertEquals(Lists.newArrayList(prepareTransfer(), prepareTransfer()), response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturnReceivedTransfers() {
        given(transferService.getTransferByReceiver(RECEIVER_USERNAME)).willReturn(Lists.newArrayList(prepareTransfer(), prepareTransfer()));

        ResponseEntity<List<TransferTO>> response = controller.getReceivedTransfers(RECEIVER_USERNAME);
        assertEquals(Lists.newArrayList(prepareTransfer(), prepareTransfer()), response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    private TransferTO prepareTransfer() {
        TransferTO transfer = new TransferTO();
        transfer.setSenderAccNumber(SENDER_NUMBER);
        transfer.setReceiverAccNumber(RECEIVER_NUMBER);
        transfer.setTitle(TITLE);
        transfer.setAmount(AMOUNT);
        transfer.setCurrency(CURRENCY);

        return transfer;
    }
}