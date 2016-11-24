package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.entity.Currency;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author notechus.
 */
@Repository("CurrencyDAO")
public class CurrencyDAOBean extends BaseEntityDAO<Currency, Long> implements CurrencyDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_NAME_QUERY = "select c from Currency c where c.name = :name";

    public CurrencyDAOBean() {
        super(Currency.class);
    }

    @Override
    public Currency findByName(String currency) {
        TypedQuery<Currency> query = entityManager.createQuery(FIND_BY_NAME_QUERY, Currency.class);
        query.setParameter("name", currency);

        return query.getSingleResult();
    }
}
