package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author notechus.
 */
@Repository("AccountDAO")
@EnableTransactionManagement
public class AccountDAOBean extends BaseEntityDAO<Account, Long> implements AccountDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_ACCOUNT_NUMBER_QUERY = "select a from Account a where a.accountNumber = :accountNumber";

    public AccountDAOBean() {
        super(Account.class);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        TypedQuery<Account> query = this.entityManager.createQuery(FIND_BY_ACCOUNT_NUMBER_QUERY, Account.class);
        query.setParameter("accountNumber", accountNumber);

        return query.getSingleResult();
    }
}
