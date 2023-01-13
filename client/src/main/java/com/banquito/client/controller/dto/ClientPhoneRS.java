package com.banquito.client.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPhoneRS implements Serializable {
    
    private String phoneNumber;
    private String phoneType;
}
