package com.sip.jbanking.domain.dao;

import com.sip.jbanking.domain.entity.Transfer;

import java.util.List;

/**
 * @author notechus.
 */
public interface TransferDAO extends EntityDAO<Transfer, Long> {

    public List<Transfer> getBySenderUsername(String username);

    public List<Transfer> getByReceiverUsername(String username);
}
