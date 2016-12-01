package com.sip.jbanking.domain.dao;

import com.sip.jbanking.domain.entity.Account;

/**
 * @author notechus.
 */
public interface AccountDAO extends EntityDAO<Account, Long> {
    public Account findByAccountNumber(String senderAccNumber);

    public Account findByUsername(String username);
}
