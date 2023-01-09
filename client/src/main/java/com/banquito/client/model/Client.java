package com.banquito.client.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "clients")
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

    @Field(value = "birthDate")
    private String birthDate;

    @Field(value = "gender")
    private String gender;

    @Field(value = "company_type")
    private String companyType;

    @Field(value = "app_legal_represent")
    private String app_legal_represent;

    @Field(value = "articles_associated_doc")
    private String articles_associated_doc;

    @Field(value = "basic_services_document")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

    @Field(value = "gender")
    private String gender;

}
