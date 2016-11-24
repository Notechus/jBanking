package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.entity.Transfer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author notechus.
 */
@Repository("TransferDAO")
public class TransferDAOBean extends BaseEntityDAO<Transfer, Long> implements TransferDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public TransferDAOBean() {
        super(Transfer.class);
    }
}