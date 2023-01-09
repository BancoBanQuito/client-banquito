package com.banquito.client.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ClientAddress {
    
    @Field(value = "code_location")
    private String codeLocation;

    @Field(value = "address_line_one")
    private String addressLineOne;

    @Field(value = "address_line_two")
    private String addressLineTwo;

    @Field(value = "latitude")
    private String latitude;

    @Field(value = "longitude")
    private String longitude;
}
