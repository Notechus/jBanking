package com.sip.jbanking.config;

import com.sip.jbanking.domain.dao.*;
import com.sip.jbanking.domain.dao.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author notechus.
 */
@Configuration
public class DAOBeans {
    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAOBean();
    }

    @Bean
    public CurrencyDAO currencyDAO() {
        return new CurrencyDAOBean();
    }

    @Bean
    public LocationDAO locationDAO() {
        return new LocationDAOBean();
    }

    @Bean
    public TransferDAO transferDAO() {
        return new TransferDAOBean();
    }

    @Bean
    public UserDAO userDAO() {
        return new UserDAOBean();
    }
}
