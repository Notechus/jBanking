package com.sip.jbanking.controller;

import com.sip.jbanking.domain.to.AccountTO;
import com.sip.jbanking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author notechus.
 */
@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(path = "api/v1/account/{username}", method = RequestMethod.GET)
    public ResponseEntity<AccountTO> getAccount(@PathVariable String username) {
        AccountTO account = accountService.findAccountByUsername(username);

        return new ResponseEntity<>(account, new HttpHeaders(), HttpStatus.OK);
    }
}
