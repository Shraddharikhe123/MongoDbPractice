package com.perennialsys.snapshot.configuration;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;

import com.mongodb.client.*;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.result.UpdateResult;
import com.perennialsys.snapshot.enums.ClassMappingEnum;
import com.perennialsys.snapshot.model.Account;
import com.perennialsys.snapshot.model.IGenericVo;
import com.perennialsys.snapshot.repository.UserRepository;
import org.bson.Document;
import org.bson.conversions.Bson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.List;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoConfiguration {


    public MongoDatabase connection() throws JsonProcessingException {
        boolean status = false;
        MongoClient mongoClient = MongoClients.create();
        MongoDatabase db = mongoClient.getDatabase("SnapShotDatabase");
        return db;

    }


}
