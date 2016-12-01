package com.sip.jbanking.service;

import com.sip.jbanking.domain.entity.Account;
import com.sip.jbanking.domain.entity.User;
import com.sip.jbanking.domain.to.UserTO;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface UserService {
    public User getUserById(long id);
    public User getUserByUsername(String username);
}
