package com.banquito.client.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class ClientReference {
    @Field(value = "name_reference")
    private String nameReference;

    @Field(value = "phone_reference")
    private String phoneReference;

    @Field(value = "related_reference")
    private String relatedReference;
}
