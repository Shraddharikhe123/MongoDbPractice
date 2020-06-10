package com.perennialsys.snapshot.controller;


import com.perennialsys.snapshot.configuration.ResponseMessage;
import com.perennialsys.snapshot.handler.BatchCompleteHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@EnableAutoConfiguration
public class BatchCompleteController {

    @Autowired
    BatchCompleteHandler batchCompleteHandler;

    @RequestMapping(value = "/IsBatchesSaved/{batchCount}",method= RequestMethod.POST)
    public ResponseEntity batchCompleteController(@PathVariable(name="batchCount",required = true) String totaBatchCount){
        int batchCount = Integer.parseInt(totaBatchCount);
        boolean isBatchDataSaved = batchCompleteHandler.processedController(batchCount);
        if (isBatchDataSaved) {
            return new ResponseEntity(ResponseMessage.DATA_SAVED_SUCCESSFULLY, HttpStatus.OK);
        } else {
            return new ResponseEntity(ResponseMessage.DATA_SAVED_UNSUCCESSFULLY, HttpStatus.CONFLICT);
        }

    }
}
