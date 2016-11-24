package com.sip.jbanking.controller;

import com.sip.jbanking.domain.to.TransferTO;
import com.sip.jbanking.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ziolson on 17.11.2016.
 */

@RestController
@CrossOrigin
public class TransferController {
    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "api/v1/transfer", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody TransferTO transferDTO) {
        if (transferService.transferMoney(transferDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
