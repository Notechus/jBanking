package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.entity.Transfer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author notechus.
 */
@Repository("TransferDAO")
public class TransferDAOBean extends BaseEntityDAO<Transfer, Long> implements TransferDAO {

    @PersistenceContext
    private EntityManager entityManager;

    private static final String FIND_BY_SENDER_USERNAME_QUERY = "select t from Transfer t join t.sender.owner o where o.username = :username";
    private static final String FIND_BY_RECEIVER_USERNAME_QUERY = "select t from Transfer t join t.receiver.owner o where o.username = :username";

    public TransferDAOBean() {
        super(Transfer.class);
    }

    @Override
    public List<Transfer> getBySenderUsername(String username) {
        TypedQuery<Transfer> query = this.entityManager.createQuery(FIND_BY_SENDER_USERNAME_QUERY, Transfer.class);
        query.setParameter("username", username);

        return query.getResultList();
    }

    @Override
    public List<Transfer> getByReceiverUsername(String username) {
        TypedQuery<Transfer> query = this.entityManager.createQuery(FIND_BY_RECEIVER_USERNAME_QUERY, Transfer.class);
        query.setParameter("username", username);

        return query.getResultList();
    }
}
