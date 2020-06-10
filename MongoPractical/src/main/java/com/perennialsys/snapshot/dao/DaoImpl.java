package com.perennialsys.snapshot.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.perennialsys.snapshot.configuration.MongoConfiguration;
import com.perennialsys.snapshot.enums.ClassMappingEnum;
import com.perennialsys.snapshot.model.IGenericVo;
import com.perennialsys.snapshot.repository.UserRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoImpl implements Dao {

    @Autowired
    MongoConfiguration mongoConfiguration;

    @Autowired
    ObjectMapper objectMapper;

    private UserRepository userRepository;

    public DaoImpl(UserRepository userRepository1) {
        this.userRepository = userRepository1;
    }


    @Override
    public boolean save(List<IGenericVo> objectData, String key) {
        MongoDatabase connection = null;
        try {
            connection = mongoConfiguration.connection();

            String name = ClassMappingEnum.findMasterClassByValue(key).getTableName();
            MongoCollection<Document> collection = connection.getCollection(name);
            for (IGenericVo company : objectData) {
                String jsonString;
                jsonString = objectMapper.writeValueAsString(company);
                Document doc = Document.parse(jsonString);
                collection.insertOne(doc);
            }
            return true;
        } catch (JsonProcessingException e) {
            return false;
        }
    }

    @Override
    public boolean saveObject(IGenericVo iGenericVo,String key) {
        MongoDatabase connection = null;
        String jsonString;
        try {
            connection = mongoConfiguration.connection();
            MongoCollection<Document> collection = connection.getCollection(key);
            jsonString = objectMapper.writeValueAsString(iGenericVo);
            Document document1 = Document.parse(jsonString);
            collection.insertOne(document1);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Object getData(String key) {
        MongoDatabase connection = null;
        try{
            int totalCount =0;
            connection = mongoConfiguration.connection();
            MongoCollection<Document> collection = connection.getCollection(key);
           BasicDBObject basicDBObject = new BasicDBObject();
           basicDBObject.append("batchStatus","InProgress");
           FindIterable<Document> documents = collection.find(basicDBObject);
            for (Document doc : documents) {
                totalCount++;
            }
            return totalCount;

        }catch(Exception e){
            return null;
        }

    }
}
