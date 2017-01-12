package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.UserDAO;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.mappings.UserMapper;
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

    @Autowired
    private UserMapper userMapper;

    public UserServiceBean() {
    }

    UserServiceBean(UserDAO userDAO, UserMapper userMapper) {
        this.userDAO = userDAO;
        this.userMapper = userMapper;
    }

    @Override
    public UserTO getUserById(long id) {
        return userMapper.userToUserTO(userDAO.findById(id));
    }
}
