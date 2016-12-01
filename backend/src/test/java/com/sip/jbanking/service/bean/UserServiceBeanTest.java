package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.UserDAO;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

/**
 * Created by ziolson on 24.11.2016.
 */
public class UserServiceBeanTest {

    private UserDAO userDAO = Mockito.mock(UserDAO.class);
    private UserServiceBean userService = new UserServiceBean(userDAO);

    private static final String ACCOUNT_NUMBER = "1234567890";
    private static final String USERNAME = "login";
    private static final String FULL_NAME = "Imie Nazwisko";


}
