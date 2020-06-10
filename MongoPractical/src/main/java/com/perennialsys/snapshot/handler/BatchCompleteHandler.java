package com.perennialsys.snapshot.handler;


import com.perennialsys.snapshot.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BatchCompleteHandler {

    @Autowired
    DataService dataService;

    public boolean processedController(int batchCount){
        String key = "uploadHistoryPojo";
       dataService.getData(key);
        return true;
    }
}
