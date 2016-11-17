package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferTO;
import com.sip.jbanking.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author notechus.
 */
@Service("TransferService")
@Transactional
public class TransferServiceBean implements TransferService {

    @Autowired
    private TransferDAO transferDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CurrencyDAO currencyDAO;

    public TransferServiceBean() {

    }

    /*package*/ TransferServiceBean(TransferDAO transferDAO, AccountDAO accountDAO, CurrencyDAO currencyDAO) {
        this.accountDAO = accountDAO;
        this.transferDAO = transferDAO;
        this.currencyDAO = currencyDAO;
    }

    @Override
    public Transfer getTransferById(long id) {
        return transferDAO.findById(id);
    }

    @Override
    public boolean transferMoney(TransferTO transfer) {
        Account sender = accountDAO.findByAccountNumber(transfer.getSenderAccNumber());
        Account receiver = accountDAO.findByAccountNumber(transfer.getReceiverAccNumber());

        if (sender == null || receiver == null) return false;

        double amount = transfer.getAmount();
        Currency currency = currencyDAO.findByName(transfer.getCurrency());
        if (!transfer.getCurrency().equals("PLN")) {
            amount *= currency.getPrice();
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);
        accountDAO.update(sender);
        accountDAO.update(receiver);

        Transfer t = prepareTransfer(transfer, sender, receiver, currency, amount);

        transferDAO.create(t);

        return true;
    }

    private Transfer prepareTransfer(TransferTO transfer, Account sender, Account receiver, Currency currency, double amount) {
        Transfer t = new Transfer();
        t.setReceiver(receiver);
        t.setSender(sender);
        t.setDescription(transfer.getTitle());
        t.setCurrency(currency);
        t.setAmount(amount);

        return t;
    }
}
