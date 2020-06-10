package com.perennialsys.snapshot.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
public class Account implements IGenericVo {

    @Id
    private String internalID;

    @JsonProperty
    private String Id;

    @JsonProperty
    private String PhotoUrl;

    @JsonProperty
    private String CreatedDate;

    @JsonProperty("batchId")
    private String batch_Id;

    public Account() {
    }


    public String getInternalID() {
        return internalID;
    }

    public void setInternalID(String internalID) {
        this.internalID = internalID;
    }

    @JsonProperty("Id")
    public String getId() {
        return Id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.Id = id;
    }

    @JsonProperty("PhotoUrl")
    public String getPhotoUrl() {
        return PhotoUrl;
    }

    @JsonProperty("PhotoUrl")
    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    @JsonProperty("CreatedDate")
    public String getCreatedDate() {
        return CreatedDate;
    }

    @JsonProperty("CreatedDate")
    public void setCreatedDate(String createdDate) {
        CreatedDate = createdDate;
    }

    @Override
    public void setBatch_Id(String batch_Id) {
        this.batch_Id = batch_Id;
    }
}
