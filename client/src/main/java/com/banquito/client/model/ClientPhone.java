package com.banquito.client.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPhone {

    private String phoneNumber;
    private String phoneType;
}
