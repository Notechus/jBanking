package com.sip.jbanking.domain.dao;

import com.sip.jbanking.domain.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author notechus.
 */
public interface AccountDAO extends EntityDAO<Account, Long> {


}
