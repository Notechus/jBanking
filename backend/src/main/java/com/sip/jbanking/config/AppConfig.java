package com.sip.jbanking.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Notechus.
 */
@Configuration
@EnableJpaRepositories("com.sip.jbanking")
@EnableTransactionManagement
public class AppConfig {

}
