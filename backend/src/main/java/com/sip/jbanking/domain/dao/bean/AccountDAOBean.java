package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.entity.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author notechus.
 */
@Repository("AccountDAO")
public class AccountDAOBean extends BaseEntityDAO<Account, Long> implements AccountDAO {

    private static final Logger log = LoggerFactory.getLogger(AccountDAOBean.class);

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_ACCOUNT_NUMBER_QUERY = "select a from Account a where a.accountNumber = :accountNumber";
    private static final String FIND_BY_USERNAME_QUERY = "select a from Account a where a.owner.username = :username";

    public AccountDAOBean() {
        super(Account.class);
    }

    @Override
    public Account findByAccountNumber(String accountNumber) {
        Account result = null;
        try {
            TypedQuery<Account> query = this.entityManager.createQuery(FIND_BY_ACCOUNT_NUMBER_QUERY, Account.class);
            query.setParameter("accountNumber", accountNumber);

            result = query.getSingleResult();
        } catch (Exception e) {
            log.error("Cannot find account, {}", e);
        }

        return result;
    }

    @Override
    public Account findByUsername(String username) {
        Account account = null;
        try {
            TypedQuery<Account> query = this.entityManager.createQuery(FIND_BY_USERNAME_QUERY, Account.class);
            query.setParameter("username", username);

            account = query.getSingleResult();
        } catch (Exception e) {
            log.error("Cannot find account, {}", e);
        }

        return account;
    }
}
