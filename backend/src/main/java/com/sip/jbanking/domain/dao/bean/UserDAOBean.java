package com.sip.jbanking.domain.dao.bean;

import com.sip.jbanking.domain.dao.UserDAO;
import com.sip.jbanking.domain.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author notechus.
 */
@Repository("UserDAO")
@EnableTransactionManagement
public class UserDAOBean extends BaseEntityDAO<User, Long> implements UserDAO {

    public UserDAOBean() {
        super(User.class);
    }
}
