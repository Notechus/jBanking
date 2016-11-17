package com.sip.jbanking.service.bean;

import com.sip.jbanking.domain.dao.AccountDAO;
import com.sip.jbanking.domain.dao.CurrencyDAO;
import com.sip.jbanking.domain.dao.TransferDAO;
import com.sip.jbanking.domain.dao.bean.AccountDAOBean;
import com.sip.jbanking.domain.dao.bean.CurrencyDAOBean;
import com.sip.jbanking.domain.dao.bean.TransferDAOBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author notechus.
 */
@Configuration
public class TestConfiguration {

    @Bean
    public AccountDAO accountDAO() {
        return new AccountDAOBean();
    }

    @Bean
    public CurrencyDAO currencyDAO() {
        return new CurrencyDAOBean();
    }

    @Bean
    public TransferDAO transferDAO() {
        return new TransferDAOBean();
    }
}
