package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.UserDAO;
import com.sip.jbanking.domain.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author notechus.
 */
@Repository("UserDAO")
public class UserDAOBean extends BaseEntityDAO<User, Long> implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDAOBean() {
        super(User.class);
    }
}
