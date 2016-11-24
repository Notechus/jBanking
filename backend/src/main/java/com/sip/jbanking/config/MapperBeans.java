package com.sip.jbanking.config;

import com.sip.jbanking.domain.mappings.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author notechus.
 */
@Configuration
public class MapperBeans {
    @Bean
    public AccountMapper accountMapper() {
        return new AccountMapperImpl();
    }

    @Bean
    public CurrencyMapper currencyMapper() {
        return new CurrencyMapperImpl();
    }

    @Bean
    public LocationMapper locationMapper() {
        return new LocationMapperImpl();
    }

    @Bean
    public TransferMapper transferMapper() {
        return new TransferMapperImpl();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapperImpl();
    }
}
