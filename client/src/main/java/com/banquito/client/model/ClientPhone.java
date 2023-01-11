package com.banquito.client.model;

import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ClientPhone {

    private String phoneNumber;
    private String phoneType;
}
