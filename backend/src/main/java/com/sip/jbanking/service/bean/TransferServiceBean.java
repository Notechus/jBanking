package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.Currency;
import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.mappings.TransferMapper;
import com.sip.jbanking.domain.to.TransferTO;
import com.sip.jbanking.service.TransferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author notechus.
 */
@Service("TransferService")
@Transactional
public class TransferServiceBean implements TransferService {

    private static final Logger log = LoggerFactory.getLogger(TransferServiceBean.class);

    @Autowired
    private TransferDAO transferDAO;

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private CurrencyDAO currencyDAO;

    @Autowired
    private TransferMapper transferMapper;

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
        log.info("Started money transfer transaction. {}", transfer);
        Account sender = accountDAO.findByAccountNumber(transfer.getSenderAccNumber());
        Account receiver = accountDAO.findByAccountNumber(transfer.getReceiverAccNumber());

        if (sender == null || receiver == null) {
            log.error("Sender or receiver account not found! Money transfer unsuccessful.");
            return false;
        }

        log.info("Found sender account: {}", sender);
        log.info("Found receiver account: {}", receiver);

        double amount = transfer.getAmount();
        Currency currency = currencyDAO.findByName(transfer.getCurrency());
        if (!transfer.getCurrency().equals("PLN")) {
            amount *= currency.getPrice();
        }

        if (!validateAndTransfer(sender, receiver, amount)) {
            log.error("Insufficient founds on sender");
            return false;
        }

        Transfer t = prepareTransfer(transfer, sender, receiver, currency, amount);
        transferDAO.create(t);
        log.info("Logged transfer to database.");

        log.info("Successfully transfered money.");
        return true;
    }

    private boolean validateAndTransfer(Account sender, Account receiver, double amount) {
        log.info("Amount to be transfered: {}", amount);

        if (sender.getBalance() - amount < 0) return false;

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountDAO.update(sender);
        log.info("Updated sender account.");
        accountDAO.update(receiver);
        log.info("Updated receiver account.");

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

    @Override
    public List<TransferTO> getTransferBySender(String username) {
        List<Transfer> transferList = transferDAO.getBySenderUsername(username);
        List<TransferTO> transferTOList = transferMapper.tranferListToListTO(transferList);

        return transferTOList;
    }

    @Override
    public List<TransferTO> getTransferByReceiver(String username) {
        List<Transfer> transferList = transferDAO.getByReceiverUsername(username);
        List<TransferTO> transferTOList = transferMapper.tranferListToListTO(transferList);

        return transferTOList;
    }
}
