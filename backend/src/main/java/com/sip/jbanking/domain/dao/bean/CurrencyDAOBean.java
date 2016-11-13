package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.entity.Currency;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author notechus.
 */
@Repository("CurrencyDAO")
@EnableTransactionManagement
public class CurrencyDAOBean extends BaseEntityDAO<Currency, Long> implements CurrencyDAO {

    public CurrencyDAOBean() {
        super(Currency.class);
    }
}
