package com.perennialsys.snapshot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AIDeclaration implements IGenericVo {


    @JsonProperty("Total_Net_Personal_Assets_A_B_C_D__c")
    public Double total_Net_Personal_Assets_A_B_C_D__c;
    @JsonProperty("Total_Final_Assets__c")
    public Double total_Final_Assets__c;
    @JsonProperty("Securities__c")
    public Double securities__c;
    @JsonProperty("Rental_Income__c")
    public Double rental_Income__c;
    @JsonProperty("Net_Value_AP__c")
    public Double net_Value_AP__c;
    @JsonProperty("Net_Value_AP2__c")
    public Double net_Value_AP2__c;
    @JsonProperty("Net_Value_1_000_000_maximum_allowed__c")
    public Double net_Value_1_000_000_maximum_allowed__c;
    @JsonProperty("Life_Insurance_Policy__c")
    public Double life_Insurance_Policy__c;
    @JsonProperty("Less_Mortgage__c")
    public Double less_Mortgage__c;
    @JsonProperty("Less_Mortgage_Credit_Facility_AP__c")
    public Double less_Mortgage_Credit_Facility_AP__c;
    @JsonProperty("Less_Mortgage_Credit_Facility_AP2__c")
    public Double less_Mortgage_Credit_Facility_AP2__c;
    @JsonProperty("Interest_Capital_Gains__c")
    public Double interest_Capital_Gains__c;
    @JsonProperty("Futures_Contracts__c")
    public Double futures_Contracts__c;
    @JsonProperty("Foreign_Exchange_Contracts__c")
    public Double foreign_Exchange_Contracts__c;
    @JsonProperty("Fair_Market_Value__c")
    public Double fair_Market_Value__c;
    @JsonProperty("Fair_Market_Value_AP__c")
    public Double fair_Market_Value_AP__c;
    @JsonProperty("Fair_Market_Value_AP2__c")
    public Double fair_Market_Value_AP2__c;
    @JsonProperty("Employment__c")
    public Double employment__c;
    @JsonProperty("Cash__c")
    public Double cash__c;
    @JsonProperty("Account__c")
    public String account__c;
    @JsonProperty("LastActivityDate")
    public String lastactivitydate;
    @JsonProperty("SystemModstamp")
    public String systemmodstamp;
    @JsonProperty("LastModifiedById")
    public String lastmodifiedbyid;
    @JsonProperty("LastModifiedDate")
    public String lastmodifieddate;
    @JsonProperty("CreatedById")
    public String createdbyid;
    @JsonProperty("CreatedDate")
    public String createddate;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("IsDeleted")
    public Boolean isdeleted;
    @JsonProperty("Id")
    public String id;
    @Id
    private Long internalId;
    private Long created;
    @JsonProperty("batchId")
    private String batch_Id;
    private Boolean isMonthEndRecord;

    @Override
    public void setBatch_Id(String batch_Id) {
        this.batch_Id = batch_Id;

    }
}
