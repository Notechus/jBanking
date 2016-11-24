package com.sip.jbanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Notechus.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.sip.jbanking")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
