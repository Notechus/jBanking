package com.sip.jbanking.controller;

import com.sip.jbanking.domain.to.TransferTO;
import com.sip.jbanking.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ziolson on 17.11.2016.
 */

@RestController
@CrossOrigin
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(path = "api/v1/transfer", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody TransferTO transferDTO) {
        if (transferService.transferMoney(transferDTO)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "api/v1/transfer/{username}/sent", method = RequestMethod.GET)
    public ResponseEntity<List<TransferTO>> getSentTransfers(@PathVariable String username) {
        List<TransferTO> transferList = transferService.getTransferBySender(username);

        return new ResponseEntity<List<TransferTO>>(transferList, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "api/v1/transfer/{username}/received", method = RequestMethod.GET)
    public ResponseEntity<List<TransferTO>> getReceivedTransfers(@PathVariable String username) {
        List<TransferTO> transferList = transferService.getTransferByReceiver(username);

        return new ResponseEntity<List<TransferTO>>(transferList, new HttpHeaders(), HttpStatus.OK);
    }
}
