package com.banquito.client.model;


import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "client")
public class Client {

    @Id
    private String id;

    @Field(value = "identification")
    private String identification;

    @Field(value = "identification_type")
    private String identificationType;

    @Field(value = "firstname")
    private String firstname;

    @Field(value = "lastname")
    private String lastname;

    @Field(value = "fullname")
    private String fullname;

    @Field(value = "status")
    private String status;

    @Field(value = "email")
    private String email;

    @Field(value = "birth_date")
    private Date birthDate;

    @Field(value = "gender")
    private String gender;

    @Field(value = "company_type")
    private String companyType;

    @Field(value = "app_legal_represent")
    private String appLegalRepresent;

    @Field(value = "articles_associated_doc")
    private String articlesAssociatedDoc;

    @Field(value = "basic_services_document")
    private String basicServicesDocument;

    @Field(value = "career")
    private String career;

    @Field(value = "company_name")
    private String companyName;

    @Field(value = "create_date_company")
    private Timestamp createDateCompany;

    @Field(value = "finger_print")
    private String fingerPrint;

    @Field(value = "income_tax_document")
    private String incomeTaxDocument;

    @Field(value = "last_status_date")
    private Timestamp lastStatusDate;

    @Field(value = "marital_status")
    private String maritalStatus;

    @Field(value = "monthly_avg_income")
    private String monthlyAvgIncome;

    @Field(value = "nationality")
    private String nationality;

    @Field(value = "signature")
    private String signature;

    @Field(value = "tax_payment_place")
    private String taxPaymentPlace;

    @Field(value = "tin_document")
    private String tinDocument;

    @Field(value = "work_status")
    private String workStatus;

    @Field(value = "client_relationship")
    private ClientRelationship clientRelationship;

    @Field(value = "client_reference")
    private ClientReference clientReference;

    @Field(value = "client_phone")
    private ClientPhone clientPhone;

    @Field(value = "client_address")
    private ClientAddress clientAddress;
    
    @Field(value = "segment")
    private String segment;
}
