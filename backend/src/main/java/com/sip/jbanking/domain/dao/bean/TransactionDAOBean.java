package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.TransactionDAO;
import com.sip.jbanking.domain.entity.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author notechus.
 */
@Repository("TransactionDAO")
@EnableTransactionManagement
public class TransactionDAOBean extends BaseEntityDAO<Transaction, Long> implements TransactionDAO {

    public TransactionDAOBean() {
        super(Transaction.class);
    }
}
