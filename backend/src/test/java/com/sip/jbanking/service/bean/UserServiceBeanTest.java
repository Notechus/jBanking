package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.UserDAO;
import com.sip.jbanking.domain.dao.bean.UserDAOBean;
import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.Location;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.mappings.UserMapper;
import com.sip.jbanking.domain.mappings.UserMapperImpl;
import com.sip.jbanking.domain.to.UserTO;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Created by ziolson
 */
public class UserServiceBeanTest {

    private UserDAO userDAO = Mockito.mock(UserDAOBean.class);
    private UserMapper userMapper = new UserMapperImpl();
    private UserServiceBean userService = new UserServiceBean(userDAO, userMapper);

    private static final long ID = 1;
    private static final String USERNAME = "login";
    private static final String NAME = "Imie";
    private static final String SURNAME = "Nazwisko";

    public void getUserByIdTest() {
        User user = createUser();
        when(userDAO.findById(ID)).thenReturn(user);
        UserTO userTO = userService.getUserById(ID);

        assertEquals(NAME + " " + SURNAME, userTO.getFullName());
    }

    private User createUser() {
        User user = new User();
        Location location = new Location();
        Account account = new Account();

        user.setId(ID);
        user.setName(NAME);
        user.setSurname(SURNAME);
        user.setUsername(USERNAME);
        user.setAccount(account);
        user.setLocation(location);

        return user;
    }

    /*private Account createAccount() {
        Account a = new Account();

        a.setId();
        a.setBalance(100.0);
    }*/

}
