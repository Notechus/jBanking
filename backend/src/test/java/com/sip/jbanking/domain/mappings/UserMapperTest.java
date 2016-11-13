package com.sip.jbanking.domain.mappings;

import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.to.UserTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @author notechus.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    private static final String FULL_NAME = "Gregory House";
    private static final String USERNAME = "Greg";
    private static final String EMAIL = "greg@email.com";
    private static final String SURNAME = "House";
    private static final String NAME = "Gregory";

    @Test
    public void shouldMapUserToUserTO() {
        User user = prepareUser();

        UserTO userTO = mapper.userToUserTO(user);

        assertEquals(expectedUserTO(), userTO);
    }

    private UserTO expectedUserTO() {
        UserTO userTO = new UserTO();
        userTO.setFullName(FULL_NAME);
        userTO.setUsername(USERNAME);
        userTO.setEmail(EMAIL);

        return userTO;
    }

    private User prepareUser() {
        User user = new User();
        user.setUsername(USERNAME);
        user.setName(NAME);
        user.setSurname(SURNAME);
        user.setEmail(EMAIL);

        return user;
    }


}