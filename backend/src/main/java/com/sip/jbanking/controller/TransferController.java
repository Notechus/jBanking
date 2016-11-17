package com.sip.jbanking.controller;

import com.sip.jbanking.domain.to.TransferDTO;
import com.sip.jbanking.service.AccountService;
import com.sip.jbanking.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ziolson on 17.11.2016.
 */

@RestController
public class TransferController {
    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "api/v1/transfer", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody TransferDTO transferDTO){
        if (transferService.transferMoney(transferDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
