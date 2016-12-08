package com.sip.jbanking.controller;

import com.sip.jbanking.service.AccountService;
import com.sip.jbanking.service.TransferService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author notechus.
 */
@Configuration
public class ControllerTestConfiguration {

    @Bean
    public TransferService transferService() {
        return Mockito.mock(TransferService.class);
    }

    @Bean
    public AccountService accountService() {
        return Mockito.mock(AccountService.class);
    }

    @Bean
    public AccountController accountController() {
        return new AccountController();
    }

    @Bean
    public TransferController transferController() {
        return new TransferController();
    }
}
