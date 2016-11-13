package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author notechus.
 */
@Repository("AccountDAO")
@EnableTransactionManagement
public class AccountDAOBean extends BaseEntityDAO<Account, Long> implements AccountDAO {


    public AccountDAOBean() {
        super(Account.class);
    }

}
