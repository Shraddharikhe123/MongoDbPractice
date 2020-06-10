package com.perennialsys.snapshot.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.perennialsys.snapshot.configuration.MongoConfiguration;
import com.perennialsys.snapshot.configuration.ResponseMessage;
import com.perennialsys.snapshot.enums.ClassMappingEnum;
import com.perennialsys.snapshot.model.IGenericVo;
import com.perennialsys.snapshot.model.UploadHistoryPojo;
import com.perennialsys.snapshot.service.DataService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class JsonMappingHandler {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    DataService dataService;

    public ResponseEntity jsonToObjectMapper(String acctData) {

    String objectKey = "";
        Long startDateTime = System.currentTimeMillis() / 1000L;
        List<IGenericVo> objectList = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(acctData);

        try {
            String batchId = (String) jsonObject.get("batchId");
            Set<String> keySet = jsonObject.keySet();
            for (String key : keySet) {
                if (!key.equals("batchId")) {
                    objectKey = key;
                    JSONArray array = jsonObject.getJSONArray(key);

                    Class clazz = ClassMappingEnum.findClassByKey(key);
                    if (clazz == null) {
                        throw new Exception(ResponseMessage.INVALID_CLASS_KEY);
                    }
                    for (int a = 0; a < array.length(); a++) {
                        IGenericVo object = null;

                        object = (IGenericVo) objectMapper
                                .readValue(array.getJSONObject(a).toString(), clazz);

                        object.setBatch_Id((String) jsonObject.get("batchId"));
                        objectList.add(object);
                    }
                }
            }
            dataService.saveData(objectList, objectKey);

            Long endDate = System.currentTimeMillis() / 1000;
            UploadHistoryPojo uploadHistoryPojo = new UploadHistoryPojo();
            uploadHistoryPojo.setBatchId(batchId);
            uploadHistoryPojo.setBatchStatus("InProgress");
            uploadHistoryPojo.setStartDate(startDateTime);
            uploadHistoryPojo.setEndDate(endDate);
            String key = "uploadHistoryPojo";
            dataService.saveObjectData(uploadHistoryPojo,key);


            return new ResponseEntity(ResponseMessage.DATA_SAVED_SUCCESSFULLY, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity(ResponseMessage.DATA_SAVED_UNSUCCESSFULLY, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}

