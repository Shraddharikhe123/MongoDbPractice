package com.perennialsys.snapshot.controller;

import ch.qos.logback.core.CoreConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.perennialsys.snapshot.configuration.MongoConfiguration;
import com.perennialsys.snapshot.configuration.ResponseMessage;
import com.perennialsys.snapshot.dao.Dao;
import com.perennialsys.snapshot.enums.ClassMappingEnum;
import com.perennialsys.snapshot.handler.JsonMappingHandler;
import com.perennialsys.snapshot.model.Account;
import com.perennialsys.snapshot.model.IGenericVo;
import com.perennialsys.snapshot.repository.UserRepository;
import jdk.internal.dynalink.support.ClassMap;
import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin(origins = "*")
@EnableAutoConfiguration
public class DataCapturingController {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
   JsonMappingHandler jsonMappingHandler;

    private UserRepository userRepository;

    public DataCapturingController(UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }

    @PostMapping(value = "/SnapShotData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Account getAll(@RequestBody String user) throws IOException {
        Account account = objectMapper.readValue(user, Account.class);
        return userRepository.save(account);
    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity dataSaveController(@RequestBody String user) throws Exception {

      return jsonMappingHandler.jsonToObjectMapper(user);

    }
}



