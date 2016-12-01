package com.sip.jbanking.service;

import com.sip.jbanking.domain.to.UserTO;

/**
 * Created by ziolson on 10.11.2016.
 */

public interface UserService {
    public UserTO getUserById(long id);
}
