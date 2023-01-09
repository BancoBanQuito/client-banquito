package com.banquito.client.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ClientPhone {

    @Field(value = "phone_number")
    private String phoneNumber;

    @Field(value = "phone_type")
    private String phoneType;
}
