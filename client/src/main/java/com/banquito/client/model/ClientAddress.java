package com.banquito.client.model;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClientAddress {

    private String codeLocation;
    private String addressLineOne;
    private String addressLineTwo;
    private String latitude;
    private String longitude;
}
