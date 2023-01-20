package com.banquito.client.controller.dto;

import com.banquito.client.model.ClientPhone;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePhoneRQ {

    private String identificationType;
    private String identification;

    private ClientPhone phone;
}
