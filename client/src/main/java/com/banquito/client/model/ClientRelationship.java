package com.banquito.client.model;

import java.sql.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class ClientRelationship {

    @Field(value = "name_relationship")
    private String name;

    @Field(value = "start_date_relationship")
    private Date startDate;

    @Field(value = "end_date_relationship")
    private Date endDate;
}