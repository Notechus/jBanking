package com.sip.jbanking.service;

import com.sip.jbanking.domain.entity.Transfer;
import com.sip.jbanking.domain.to.TransferDTO;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface TransferService {

    public Transfer getTransferById(long id);

    public boolean transferMoney(TransferDTO transfer);
}
