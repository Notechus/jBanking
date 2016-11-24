package com.sip.jbanking.config;

import com.sip.jbanking.service.TransferService;
import com.sip.jbanking.service.bean.TransferServiceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author notechus.
 */
@Configuration
public class ServiceBeans {

    @Bean
    public TransferService transferService() {
        return new TransferServiceBean();
    }
}
