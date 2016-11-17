package com.sip.jbanking.domain.dao;

import com.sip.jbanking.domain.entity.Currency;

/**
 * @author notechus.
 */
public interface CurrencyDAO extends EntityDAO<Currency, Long> {

    public Currency findByName(String currency);
}
