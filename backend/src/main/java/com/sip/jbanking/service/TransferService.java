package com.sip.jbanking.service;

import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferTO;

import java.util.List;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface TransferService {

    public Transfer getTransferById(long id);

    public boolean transferMoney(TransferTO transfer);
    public List<TransferTO> getTransferBySender(String username);
    public List<TransferTO> getTransferByReceiver(String username);
}
