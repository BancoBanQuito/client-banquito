package com.banquito.client.controller.dto;

import com.banquito.client.model.ClientAddress;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateAdressRQ {

    private String identificationType;
    private String identification;

    private ClientAddress adress;
}