package com.banquito.client.controller.dto;
import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientPhoneRQ implements Serializable{
    private String phoneNumber;
    private String phoneType;
}