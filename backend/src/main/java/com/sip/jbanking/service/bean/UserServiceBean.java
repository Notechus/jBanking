package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.UserDAO;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.to.UserTO;
import com.sip.jbanking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ziolson on 24.11.2016.
 */

@Service("UserService")
@Transactional
public class UserServiceBean implements UserService {

    @Autowired
    private UserDAO userDAO;

    public UserServiceBean() {
    }

    UserServiceBean(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }
}
